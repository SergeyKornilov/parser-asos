<#import "parts/common.ftlh" as a>

<@a.page>

<div class="container">
    <div class="row">
     <a href="service">Service page</a>
    </div>
</div>

<#list products as product>
    <container>
        <row>
            <col></col>
        </row>
    </container>
    <ul>
        <li><p>id</p>${product.id}</li>
        <li><p>код товара</p>${product.productCode}</li>
        <li><p>название</p>${product.name}</li>
        <li><p>дата добавления</p>${product.dateAdd}</li>
        <li><p>id категории</p>${product.idCategory}</li>
        <li><p>ссылка</p>${product.productUrl}</li>
        <li><p>картинка</p><img src="${product.urlImg}"></li>
    </ul>
    <hr align="left" size="3" color="#0000dd" />
</#list>
</@a.page>