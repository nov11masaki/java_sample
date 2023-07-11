<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>ツイート編集</title>
    </head>
    <body>
        <form action="/mutter/edit" method="post">
            <div class="form-group">
                <textarea name="text"></textarea>
            </div>
            <button type="submit">送信</button>
        </form>
    </body>
</html>