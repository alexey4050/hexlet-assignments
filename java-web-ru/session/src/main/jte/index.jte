@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
<h1>Привет, Хекслет!</h1>
@if(page.getName() != null)
    <p>Добро пожаловать, ${page.getName().toString()}!</p>
    <form action="${NamedRoutes.logoutPath()}" method="post">
        <button type="submit">Выйти</button>
    </form>
@else
    <p> Новый пользователь </p>
    <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
@endif
`
)
