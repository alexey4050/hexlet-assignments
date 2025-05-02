@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes
@param EditPostPage page

@template.layout.page(
    content =@`
        <h2> Редактируем пост id=${page.getId()}</h2>
        <form action="/posts/${(page.getId())}" method="post">
            <div class="mb-3">
                <label class="form-label">Название</label>
                    <input type="text" class="form-control" name="name" value="${page.getName()}">
            </div>
            <div class="mb-3">
                <label class="form-label">Содержание</label>
                    <textarea class="form-control" name="body">${page.getBody()}</textarea>
            </div>
            <input type="submit" class="btn btn-primary" value="Сохранить">
        </form>
    `
    )

