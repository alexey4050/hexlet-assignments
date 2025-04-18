@import exercise.dto.users.UsersPage
@param UsersPage usersPage

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Список пользователей</title>
</head>
<body>
<div class="container">
    <h1>Список пользователей</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Email</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        @for(var user : usersPage.getUsers())
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getEmail()}</td>
                <td><a href="/users/${user.getId()}" class="btn btn-primary">Просмотреть</a></td>
            </tr>
        @endfor
        </tbody>
    </table>
</div>
</body>
</html>
