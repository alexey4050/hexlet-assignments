@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <h1>Список пользователей</h1>
    <ul class="list-group">
        @for(var user : page.getUsers()) {
            <li class="list-group-item">
                <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
            </li>
        }
        </ul>
        @endfor
    `
)

