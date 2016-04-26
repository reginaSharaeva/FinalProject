<#-- @ftlvariable name="good" type="ru.kpfu.itis.toyshop.domain.Good" -->
<#-- @ftlvariable name="goodInCart" type="boolean" -->
<#include "templates/main_template.ftl">
<@mainTemplate scripts=["js/my/catalog.js"] />
<#macro m_body>
<body>
<h1 class="starter-template">Описание товара</h1>
<div class="main-block">
    <#if good??>
        <img src="/resources/images/${good.image}" class="img-good">
        <span class="span-good">${good.name}</span>
        <span class="span-good">${good.description}</span>
        <span class="span-good">${good.category.id} ${good.category.name}</span>
        <span class="span-good">${good.price}.00 руб.</span>
        <#if goodInCart?has_content>
            <a href="/cart"><input type="submit" value="Добавлено" class="add-tocard-catalog"></a>
        <#else>
            <a href="/cart"><input type="submit" value="Добавить в корзину" class="add-tocard-catalog js_addToCart" data-id="${good.id}" ></a>
        </#if>
    <#else>
        Данного товара нет!
    </#if>
</div>
</body>
</#macro>