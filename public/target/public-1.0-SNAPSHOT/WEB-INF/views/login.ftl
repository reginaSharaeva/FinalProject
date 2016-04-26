<#-- @ftlvariable name="orders" type="java.lang.String" -->
<#include "templates/main_template.ftl">
<@mainTemplate title="Мир игрушек" />
<#macro m_body>
<div class="account-in">
    <div class="container">
        </br>
        </br>
        </br>
        </br>
        <div id="legend">
            <legend class="">Вход</legend>
        </div>
        <div class="col-md-7 account-top">
            <#if error?has_content>
                <div style="color: red;">Ошибка! Пожалуйста проверьте Ваш e-mail и пароль!</div>
            </#if>
            <form name="authForm" id="authForm" action="/j_spring_security_check" method="post">
                <div>
                    <span>Email</span>
                    <input type="text" name="j_username" id="login"/>
                </div>
                <div>
                    <span class="pass">Password</span>
                    <input type="password" name="j_password" />
                </div>
                <div>
                    </br>
                    <input id="remember_me" name="j_spring_security_remember_me" type="checkbox"/>
                    <label for="remember_me" class="inline">Запомнить меня</label>
                </div>
                <a href="/"><input type="submit" value="Вход" class="btn btn btn-lg btn-success"/></a>
                <a href="/reg" style="margin-left: 15px;">Зарегистрироваться</a>
            </form>
            </br>
        </div>
        <div class="col-md-5 left-account "></div>
        <div class="clearfix"> </div>
    </div>
</div>
</#macro>






