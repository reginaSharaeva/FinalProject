<#-- @ftlvariable name="listMenu" type="java.util.List<ru.kpfu.itis.toyshop.domain.Category>" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#macro mainTemplate title="Мир Игрушек" styles=[] scripts=[] >
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/custom.css" rel="stylesheet">
    <link href="/resources/css/catalog.css" rel="stylesheet">
    <link href="/resources/css/good.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/main-page.css" rel="stylesheet">
    <link href="/resources/css/cart.css" rel="stylesheet">
    <link href="/resources/css/cabinet.css" rel="stylesheet">
    <link href="/resources/css/static.css" rel="stylesheet">
<#list styles as css>
    <link rel="stylesheet" href="/resources/${css}" type="text/css" />
</#list>

    <script src="/resources/js/jquery-1.12.1.min.js"></script>
    <script src="/resources/js/prefixfree.min.js"></script>
    <script src="/resources/js/index.js"></script>
<#list scripts as js>
    <script src="/resources/${js}" type="text/javascript" defer></script>
</#list>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li ><a href="/">Мир Игрушек</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="/catalog">Каталог</a>
                    <ul class="dropdown-menu">
                        <#if listMenu?has_content>
                            <#list listMenu as menu>
                                <li><a href="/catalog?id=${menu.id}">${menu.alias}</a></li>
                            </#list>
                        </#if>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <@sec.authorize ifAnyGranted="ROLE_ANONYMOUS">
                    <li><a class="login" href="/login">Вход</a></li>
                    <li><a class="login" href="/reg">Регистрация</a></li>
                </@sec.authorize>
                <#-- Если уже авторизован, то ссылки в личный кабинет и на выход -->
                <@sec.authorize access="isAuthenticated()">

                        <li class="user_desc">
                            <a class="login" href="/cabinet">
                                <@sec.authentication property="principal.username" />
                            </a>
                        </li>


                        <li class="user_desc" style="padding-left: 10px;">
                            <a class="login" href="/logout">Выйти</a>
                        </li>

                </@sec.authorize>
                <li><a href="/cart">Корзина</a></li>
            </ul>
        </div>
    </div>
</nav>
    <@m_body/>

    <#include "static.ftl"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
</#macro>