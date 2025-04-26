@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

<html lang ="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Создание статьи</title>
</head>
<body>
<div class="container">
    <h1>Создание статьи</h1>
    <form action="/articles" method="post">
        <div class="mb-3">
            <label for="title" class="form-label">Название статьи</label>
            <input type="text" class="form-control" id="title" name="title" value="${page.getTitle()}">
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
            <textarea class="form-control" id="content" name="content">${page.getContent()}</textarea>
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
</html>