

    <#import "/spring.ftl" as spring/>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <link rel="stylesheet"
              type="text/css" href="<@spring.url '/css/style.css'/>"/>
    </head>
<body>

<div>
    <fieldset>
        <legend>Insert fragment</legend>
        <form name="student" action="" method="POST">
            <#--            ID:<@spring.formInput "studentForm.id" "" "text"/>-->
            <br>
           containing:<@spring.formInput "logForm.nameLogFragment" "" "text"/>
            <br>
            <input type="submit" value="Find"/>
        </form>
    </fieldset>
</div>

<br>
<br>
<br>
<br>

<fieldset>
    <div>
        <label style="border-width: 1px">
            ${logForm.namePanel}

        </label>
    </div>

</fieldset>
</body>
</html>