<#-- @ftlvariable name="contains" type="boolean" -->
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "../templates/main_template.ftl">
<@mainTemplate title="Мир Игрушек" />
<#macro m_body>
<div class="account-in">
    <div class="container">
        <@form.form commandName="regForm" action="/reg" acceptCharset="UTF-8" method="post">
        </br>
        </br>
        </br>
        </br>
            <div class="register-top-grid">
            <div id="legend">
                <legend class="">Регистрация</legend>
            </div>
            <#--<@form.errors path="*" cssStyle="color: red;" />-->
                <div>
                    <span>Name<label>*</label></span>
                    <@form.input path="name"/>
                    <@form.errors path="name" cssStyle="color: red;" />
                    <p class="help-block">Введите имя (имя может содержать любые символы кроме пробела)</p>
                </div>
                <div>
                    <span>E-Mail<label>*</label></span>
                    <@form.input path="email"/>
                    <@form.errors path="email" cssStyle="color: red;" />
                    <p class="help-block">Введите Ваш E-Mail</p>
                </div>

                <div>
                    <span>Password<label>*</label></span>
                    <@form.password path="password" />
                    <@form.errors path="password" cssStyle="color: red;" />
                    <p class="help-block">Введите пароль (пароль должен содержать не менее 7 символов)</p>
                </div>
                <div>
                    <span>Confirm Password<label>*</label></span>
                    <@form.password path="confirmPassword" />
                    <@form.errors path="confirmPassword" cssStyle="color: red;" />
                    <p class="help-block">Подтвердите пароль</p>
                </div>
                <div class="clearfix"> </div>
            <div class="clearfix"> </div>
            <div class="register-but">
                <input type="submit" value="Зарегистрироваться" class="btn btn btn-lg btn-success">
                <div class="clearfix"> </div>
            </div>
        </@form.form>
        </br>
        <#if contains?has_content>
            <span style="color: red"> Возможно Вы уже регистрировались по этому E-Mail</span>
        </#if>
    </div>
</div>
</#macro>

