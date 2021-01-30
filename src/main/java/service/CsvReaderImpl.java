package service;

import com.dto.CsvReaderDto;
import com.model.SalesRecords;
import com.model.SalesRecordsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CsvReaderImpl implements CsvReader {
    @Autowired
    private SalesRecordsRepository recordsRepository;

    /**
     * Used to save the data from excel file to SQL database.
     * @param readerDtoList
     */
    @Override
    public void save(List<CsvReaderDto> readerDtoList) {
        List<SalesRecords> salesRecords = readerDtoList
                .stream()
                .map(SalesRecords::from)
                .collect(Collectors.toList());

        recordsRepository.saveAll(salesRecords);
    }
}
