package uz.ticket.eticket.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.user.User;
import uz.ticket.eticket.payload.UserDTO;
import uz.ticket.eticket.repository.user.UserRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Component
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final BaseResponse baseResponse;

    @Autowired
    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, ModelMapper mapper, BaseResponse baseResponse) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.baseResponse = baseResponse;
    }


    public ResponseEntity<?> register(UserDTO userDto) {
        Optional<User> byEmail = userRepository.findByUsername(userDto.getUsername());
        if (byEmail.isEmpty()) {
            User user = mapper.map(userDto, User.class);
            ApiResponse SUCCESS = baseResponse.getSUCCESS();
            User save = userRepository.save(user);
            SUCCESS.setData(save);
            return ResponseEntity.ok().body(SUCCESS);

        }
        return ResponseEntity.ok().body(baseResponse.getUSER_ALREADY_EXISTS());
    }


    public ResponseEntity<?> login(UserDTO userDto) {
        Optional<User> byEmail = userRepository.findByUsername(userDto.getUsername());
        if (byEmail.isEmpty()) {
            return ResponseEntity.ok().body(baseResponse.getUSER_NOT_FOUND());

        }
        if (byEmail.get().getPassword().equals(userDto.getPassword())) {
            ApiResponse SUCCESS = baseResponse.getSUCCESS();
            SUCCESS.setData(byEmail.get());
            return ResponseEntity.ok().body(SUCCESS);
        }

        return ResponseEntity.ok().body(baseResponse.getUSER_NOT_FOUND());
    }


    public ResponseEntity<?> getAllUsers() {
        List<User> all = userRepository.findAll();
        ApiResponse success = baseResponse.getSUCCESS();
        success.setData(all);
        return ResponseEntity.ok().body(success);

    }


    public ApiResponse getUserFile() throws IOException {
        Workbook workbook = new XSSFWorkbook();
         String columns[] = {"id","username", "role" , "createdBy", "updatedBy", "createdDate", "updatedDate"};
        CreationHelper createHelper = workbook.getCreationHelper();

        Sheet sheet = workbook.createSheet("Users");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);

        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }


        List<User> users = userRepository.findAll();

        int rowNum = 1;
        for(User user: users ) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(user.getId());

            row.createCell(1)
                    .setCellValue(user.getUsername());
            row.createCell(2)
                    .setCellValue(user.getRole().toString());

//            row.createCell(3)
//                    .setCellValue(user.getCreatedBy());
//
//            row.createCell(4)
//                    .setCellValue(user.getUpdatedBy());
//            row.createCell(5)
//                    .setCellValue(user.getCreatedDate().toString());
//            row.createCell(6)
//                    .setCellValue(user.getUpdatedDate().toString());
        }

        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }


        FileOutputStream fileOut = new FileOutputStream("/Users/ismoilovdavron/IdeaProjects/eTicket/src/main/resources/file/users.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
        ApiResponse success = baseResponse.getSUCCESS();
        success.setData("users.xlsx");

        return  success;
    }




}
