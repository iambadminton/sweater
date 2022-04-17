<#import "parts/common.ftl" as c>

<@c.page>
    <h5>${username}</h5>
    ${message?if_exists}
    <form method="post">
        <div><label class="col-form-label"> Password: <input type="password" name="password" class="form-control"/>
            </label></div>

            <div><label class="col-form-label"> Email: <input type="email" name="email"
                                                              placeholder="some@some.com"
                                                              class="form-control"
                                                              value="${email!''}"
                    />

                </label></div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</@c.page>