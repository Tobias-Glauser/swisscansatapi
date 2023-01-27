package ch.divtechx.swisscansatapi.flightData;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class SearchResult<T> {
    private int page;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private List<T> content;

    public SearchResult(Page<T> page) {
        this.page = page.getPageable().getPageNumber();
        this.pageSize = page.getPageable().getPageSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.content = page.getContent();
    }
}
