package org.p7.promocionsocial.app.models.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseList<T> extends  Response{
    private List<T> lista;
}
