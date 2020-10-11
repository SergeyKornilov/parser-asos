<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<form method="post">
    <input type="text" name="url" placeholder="Введите url" value=""/>
    <button type="submit">Добавить</button>

    <input type="text" name="domainName" placeholder="Имя домена" />
    <button type="submit">Добавить</button>

</form>

<div>
    <a href="/">Main</a>
</div>

<div>
    <#list domains as domain>
        <ul>
            <li>
                ${domain.nameDomain}
                <a href="/service/delete?name=${domain.nameDomain}">DELETE</a>
            </li>
        </ul>
    </#list>
</div>

</body>
</html>