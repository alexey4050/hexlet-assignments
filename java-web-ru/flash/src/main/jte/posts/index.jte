@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
    page = page,
content = @`
    <h1>${page.getHeader()}</h1>
    <ul>
        @for(var post : page.getPosts())
            <li><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></li>
        @endfor
    </ul>
`
)
