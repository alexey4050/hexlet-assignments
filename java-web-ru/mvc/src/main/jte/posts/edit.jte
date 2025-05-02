@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes
@param EditPostPage page

@template.layout.page(
    content =@`
    @if(page.getErrors() != null)
        <div class="mb-3">
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
            </ul>
        </div>
        @endif
    
    <div class="mx-auto p-4 py py-md-5">
        <form action="${NamedRoutes.postPath(page.getPost().getId())}" method="post">
            <input type="hidden" name="id" value="${page.getPost().getId()}">
            <div class="mb-3">
                <label class="form-label">
                    Название
                    <input type="text" class="form-control" name="name" value="${page.getPost().getName()}">
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Содержание
                </label>
                <label>
                    <textarea class="form-control" rows="20" cols="70" type="text" name="body">${page.getPost().getBody()}</textarea>
                </label>
            </div>
            <input type="submit" class="btn btn-primary" value="Сохранить">
        </form>
    </div>
    `
    )

