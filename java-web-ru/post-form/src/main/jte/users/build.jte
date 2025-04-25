@import exercise.model.User;
@param User page


@template.layout.page(
        content=@`
    <form action="/jte/users" method="post">
        <div class="mb-3">
            <label for="nameInput" class="form-label">Имя</label>
            <input type="text" class="form-control" id="nameInput" name="name" value="${page.getFirstName()}" placeholder="Ваше имя" required>
            <div class="mb-3">
                <label for="lastNameInput" class="form-label">Фамилия</label>
                <input type="text" class="form-control" id="lastNameInput" name="lastName" placeholder="Ваша фамилия" required>
            </div>
            <div class="mb-3">
                <label for="emailInput" class="form-label">Электронная почта</label>
                <input type="email" class="form-control" id="emailInput" name="email" placeholder="Введите ваш email" required>
            </div>
            <div class="mb-3">
                <label for="passwordInput" class="form-label">Пароль</label>
                <input type="password" class="form-control" id="passwordInput" name="password" placeholder="Введите ваш пароль" required>
            </div>
            <button type="submit" class="btn btn-primary">Создать пользователя</button>
        </div>
    </form>
    `
    )
