package com.brilhador.project.models.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SearchRequest<T> {
    public SearchRequest(T query) {
        this.page = new Page();
        this.query = query;
    }

    @Valid
    @NotNull
    private Page page;

    @Valid
    @NotNull
    private T query;
}
