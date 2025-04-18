@import exercise.dto.users.UserPage
@param UserPage userPage

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Пользователь ${userPage.getUser().getFirstName()}</title>
</head>
<body>
    <div class="container">
        <h1>${userPage.getUser().getFirstName()} ${userPage.getUser().getLastName()}</h1>
        <p>Email: ${userPage.getUser().getEmail()}</p>
        <a href="/users" class="btn btn-primary">Назад к списку пользователей</a>
    </div>
</body>
</html>
