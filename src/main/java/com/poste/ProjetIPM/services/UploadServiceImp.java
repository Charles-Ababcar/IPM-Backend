/*package com.poste.ProjetIPM.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.poste.ProjetIPM.Repository.IPM_FactureRepository;
import com.poste.ProjetIPM.entities.IPM_Facture;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class UploadServiceImp  implements  UploadService{
     @Autowired
    IPM_FactureRepository ipm_factureRepository;
    @Override
    public boolean saveDataFromUploadFile(MultipartFile file) {
        boolean isFlag = false;
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if(extension.equalsIgnoreCase("json")){
            isFlag = readDataFromJson(file);
        } else if(extension.equalsIgnoreCase("csv")){
            isFlag = readDataFromCsv(file);
        } else if(extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("xlsx")){
            isFlag = readDataFromExcel(file);
        }

        return isFlag;
    }
    // Lire le format de fichier Excel
    private boolean readDataFromExcel(MultipartFile file) {
        if (ipm_factureRepository.findByFileName(FilenameUtils.getName(file.getOriginalFilename()))!=null) {
            return false;
        } else {
            Workbook workbook = getWorkBook(file);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            rows.next();
            while (rows.hasNext()) {
                Row row = rows.next();
                //Creation de l'objet
                IPM_Facture ipm_facture= new IPM_Facture();
                if (row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    Long idfacture=Double.valueOf(row.getCell(0).getNumericCellValue()).longValue();
                    ipm_facture.setIdfacture(idfacture);
                } else if (row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING) { //Cell.CELL_TYPE_STRING
                    ipm_facture.setIdfacture(Double.valueOf(row.getCell(0).getNumericCellValue()).longValue());
                }
                if (row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {
                    ipm_facture.setMatricule(row.getCell(1).getStringCellValue());
                }
                if (row.getCell(2).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    ipm_facture.setIpm_prestataire(Double.valueOf(row.getCell(2).getStringCellValue()).longValue());
                } else if (row.getCell(2).getCellType() == Cell.CELL_TYPE_STRING) { //Cell.CELL_TYPE_STRING
                    ipm_facture.setIpm_prestataire(Double.valueOf(row.getCell(0).getNumericCellValue()).longValue());
                }
                if (row.getCell(3).getCellType() == CellType.STRING) {
                    ipm_facture.setAdresse(row.getCell(3).getStringCellValue());
                }
                if (row.getCell(4).getCellType() == CellType.STRING) {
                    ipm_facture.setAdresseComplementaire(row.getCell(4).getStringCellValue());
                }
               /* if (row.getCell(5).getCellType() == CellType.NUMERIC) {
                    String codePostal = NumberToTextConverter.toText(row.getCell(5).getNumericCellValue());
                    ipm_facture.setCodePostal(codePostal);
                } else if (row.getCell(5).getCellType() == CellType.STRING) {
                    ipm_facture.setCodePostal(row.getCell(5).getStringCellValue());
                }
                if (row.getCell(6).getCellType() == CellType.STRING) {
                    ipm_facture.setCommune(row.getCell(6).getStringCellValue());
                }
                if (row.getCell(7).getCellType() == CellType.NUMERIC) {
                    ipm_facture.setMontantEuro(row.getCell(7).getNumericCellValue());

                } else if (row.getCell(7).getCellType() == CellType.STRING) {
                    beneficiaire.setMontantEuro(Double.parseDouble(row.getCell(7).getStringCellValue()));
                    //beneficiaire.setMontantEuro(montantEuro);
                }
                if (row.getCell(8).getCellType() == CellType.NUMERIC) {
                    ipm_facture.setMontantCFA(row.getCell(8).getNumericCellValue());

                } else if (row.getCell(8).getCellType() == CellType.STRING) {
                    ipm_facture.setMontantCFA(Double.parseDouble(row.getCell(8).getStringCellValue()));
                    //beneficiaire.setMontantEuro(montantEuro);
                }
                if (row.getCell(9).getCellType() == CellType.STRING) {
                    ipm_facture.setMoisEcheance(row.getCell(9).getStringCellValue());
                }

                ipm_facture.setFileName(FilenameUtils.getName(file.getOriginalFilename()));
                //beneficiaire.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
                ipm_facture.setStatus("en instance");
                //beneficiaire.setSuspendu("f");
                ipm_facture.setDateChargement(new Date());
                ipm_factureRepository.save(ipm_facture);
            }

            return true;
        }
    }

    private Workbook getWorkBook(MultipartFile file) {
        Workbook workbook = null;
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        try {
            if (extension.equalsIgnoreCase("xlsx")){
                workbook = new XSSFWorkbook(file.getInputStream());
            } else if (extension.equalsIgnoreCase("xls")){
                workbook = new HSSFWorkbook(file.getInputStream());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return workbook;
    }

    // Lire le format de fichier CSV
    private boolean readDataFromCsv(MultipartFile file) {
        if (ipm_factureRepository.findByFileName(FilenameUtils.getName(file.getOriginalFilename()))!=null) {
            return false;
        } else {
            try{
                InputStreamReader reader = new InputStreamReader(file.getInputStream());
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
                List<String[]> rows = csvReader.readAll();
                for (String[] row : rows){
                    ipm_factureRepository.save(new IPM_Facture(row[0], row[1], row[2], row[3], row[4], , Double.parseDouble(row[7]), Double.parseDouble(row[8]), row[9], FilenameUtils.getName(file.getOriginalFilename()), "en instance", "non", new Date()));
                }
                return true;
            } catch (Exception e){
                return false;
            }
        }

    }

    // Lire le format de fichier JSON
    private boolean readDataFromJson(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            List<IPM_Facture> ipm_factures= Arrays.asList(mapper.readValue(inputStream, IPM_Facture[].class));
            if(ipm_factures!=null && ipm_factures.size()>0){
                for(IPM_Facture ipm_facture : ipm_factures){
                    ipm_facture.setFileName(FilenameUtils.getExtension(file.getOriginalFilename()));
                   // ipm_facture.setStatus("en instance");
                    //beneficiaire.setSuspendu("non");
                    ipm_facture.setDate_facture(new Date());
                    ipm_factureRepository.save(ipm_facture);
                }
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
*/
