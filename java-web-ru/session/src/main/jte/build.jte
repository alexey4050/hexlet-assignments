@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
content = @`
<h1>Вход</h1>
@if(page.getError() != null)
    <div class="alert alert-danger">${page.getError()}</div>
@endif
<form action="${NamedRoutes.loginPath()}" method="post">
    <input type="text" name="name" placeholder="Имя пользователя" required />
    <input type="password" name="password" placeholder="Пароль" required />
    <button type="submit">Войти</button>
</form>
`
)
