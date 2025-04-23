@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

@template.layout.page(
content = @`
    <h1>Список пользователей</h1>
    <form action="/users" method="get" class="mb-3">
        <div class="input-group">
            <input type="search" name="term" class="form-control" placeholder="Введите имя"
               value="${"term" != null ? "term" : ""}" autofocus>
            <button type="submit" class="btn btn-outline-primary"> Искать</button>
        </div>
    </form>

    @if (page.getUsers().isEmpty())
        <p>Совпадений не найдено</p>
    @else
        <ul class="list-group">
            @for (User user : page.getUsers())
                <li class="list-group-item">
                    ${user.getFirstName()} ${user.getLastName()} (${user.getEmail()})
                </li>
            @endfor
        </ul>
    @endif
`
)



