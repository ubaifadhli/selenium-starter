package controller;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CatAPIResponse {
    public List<Object> breeds;
    public String id;
    public String url;
    public String width;
    public String height;
}
