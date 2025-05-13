@import gg.jte.Content
@import exercise.dto.BasePage
@import exercise.util.NamedRoutes
@param Content content
@param BasePage page = null

<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Flash-message</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="${NamedRoutes.rootPath()}">Главная</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="${NamedRoutes.buildPostPath()}">Создать пост</a></li>
                <li class="nav-item"><a class="nav-link" href="${NamedRoutes.postsPath()}">Список постов</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    @if(page != null && page.getFlash() != null)
        <div class="alert alert-success">
            ${page.getFlash()}
        </div>
    @endif
    <main class="container mt-4">
        ${content}
    </main>
</div>
<footer class="text-center mt-4">
    <p>© 2025 Мой сайт. Все права защищены.</p>
</footer>
</body>
</html>

