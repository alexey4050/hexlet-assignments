@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    <h1>Список постов</h1>
    <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
    @if (page.getCurrentPage() <= 1)
        <a href="#" class="btn btn-primary">-----</a>
    @else
        <a href="/posts?page=${page.getCurrentPage() - 1}" class="btn btn-primary">Назад</a>
    @endif

    <a href="#" class="btn btn-primary">${page.getCurrentPage()}</a>

    @if (page.getCurrentPage()<page.getTotalPages())
        <a href="/posts?page=${page.getCurrentPage() + 1}" class="btn btn-primary">Вперед</a>
    @else
        <a href="#" class="btn btn-primary">------</a>
    @endif
    </div>

    @for(var post : page.getPosts())
        <ul>
            <li><a href="/posts/${post.getId()}">${post.getName()}</a></li>
            <p>${post.getBody()}</p>
        </ul>
    @endfor

    </div>
`
)

