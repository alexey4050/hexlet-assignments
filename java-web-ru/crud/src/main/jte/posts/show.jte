@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`
    <p><a class="btn btn-primary" href="/posts" >Назад к списку постов</a></p>
    <h2>${page.getPost().getName()}</h2>
    <p>${page.getPost().getBody()}</p>
`
)
