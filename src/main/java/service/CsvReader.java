package service;

import com.dto.CsvReaderDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CsvReader {
    void save(List<CsvReaderDto> readerDtoList);
}
