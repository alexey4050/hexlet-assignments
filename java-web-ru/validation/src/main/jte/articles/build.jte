@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
<body>
<div class="container">
    <h1>Создание статьи</h1>
    <form action="/articles" method="post">
        <div class="mb-3">
            <label for="title" class="form-label">Название статьи</label>
            <input type="text" class="form-control" id="title" name="title" value="${page.getTitle() != null ? page.getTitle() : ""}">
            @if(page.getErrors() != null && page.getErrors().containsKey("title"))
                <div class="invalid-feedback">
                    @for(var error : page.getErrors().get("title"))
                        ${error.getMessage()}
                    @endfor
                </div>
            @endif
        </div>
        <div class="mb-3">
            <label for="content" class="form-label">Содержимое статьи</label>
            <textarea class="form-control" id="content" name="content">${page.getContent() != null ? page.getContent() : ""}</textarea>
            @if(page.getErrors() != null && page.getErrors().containsKey("content"))
            <div class="invalid-feedback">
                @for(var error : page.getErrors().get("content"))
                    ${error.getMessage()}
            </div>
            @endfor
        </div>
        @endif
        <button type="submit" class="btn btn-primary">Создать</button>
    </form>
</div>
</body>
`
)