<#macro login path isRegisterForm>
    <form action="${path}" method="post">
        <div><label class="col-form-label"> User Name : <input type="text" name="username" class="form-control"/>
            </label></div>
        <div><label class="col-form-label"> Password: <input type="password" name="password" class="form-control"/>
            </label></div>
        <#if isRegisterForm>
        <div><label class="col-form-label"> Email: <input type="email" name="email"
                                                          placeholder="some@some.com"
                                                          class="form-control"/>
                </#if>
            </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <#if !isRegisterForm><a href="/registration">Add new user</a></#if>
        <button type="submit" class="btn btn-primary"><#if isRegisterForm>Create<#else>Sign In</#if></button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Sign out</button>

    </form>

</#macro>