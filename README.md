# Backend spaceacode

**1. Post /register - запрос на регистрацию пользователя.**

Входные праметры:

+ String nickname
+ String email
+ String password

**Email должен быть всегда уникальным**

Ответ сервера в случае удачи:

```
{
    "code": 0,
    "message": "No error"
}
```

В случае неудачи:

```
{
    "code": 1,
    "message": "Указанный адрес электронной почты уже используется"
}
```

**2. Post /auth - запрос на авторизацию пользователя.**

Входные параметры:

+ String login
+ String password

Логином может быть nickname или email.

Ответ сервера в случае удачи:
```
{
    "token": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkZXpsbzIxQHlhbmRleC5ydSIsImNsaWVudFR5cGUiOiJ1c2VyIiwibmlja25hbWUiOiJkZXpsbyIsInRva2VuX2V4cGlyYXRpb25fZGF0ZSI6MTU5OTE0MTczMTA3NywiZXhwIjoxNTk5MTQxNzMxLCJ1c2VySUQiOiIyOCIsImlhdCI6MTU5OTA1NTMzMSwianRpIjoiMjgiLCJ0b2tlbl9jcmVhdGVfZGF0ZSI6MTU5OTA1NTMzMTA3N30.miIqQL2ijkxOpkiqtrMn96bn7Y33iIny90RD9_UEz6E"
}
```

**3. Get /blog/article - запрос для получения всех блогов.**

Ответ:
 ```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": [
        {
            "id": 5,
            "authorId": 2,
            "nickname": "Pavel",
            "title": "A new option is available to VKontakte users",
            "article": "The social network \"VKontakte\" has launched a new function for community owners - \"Reports\", according to a press release from the social network.",
            "dateCreated": "2020-08-01 00:00:00",
            "hoursAfter": 20,
            "daysAfter": 123,
            "hashTagId": 2,
            "hashTagName": "WEB",
            "likes": 0,
            "views": 0
        },
```

**4.Post /blog/addArticle - запрос для добавления блога**

Вход:

+ Integer authorId;
+ String title;
+ String article;
+ Integer hashTagId; 

Выход: 

```
    {
        "result": {
            "code": 0,
            "message": "No error"
        },
        "payload": null
    }
```

**5. Get /html**

Выход: 

```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": {
        "html": {
            "basic": [
                {
                    "id": 1,
                    "name": "Introduction"
                }
            ],
            "middle": [
                {
                    "id": 7,
                    "name": "Headings"
                }
            ],
            "expert": [
                {
                    "id": 77,
                    "name": "Extra markup"
                }
            ]
        },
        "htmlExams": {
            "basic": [
                {
                    "id": 105,
                    "name": "First page"
                }
            ],
            "middle": [
                {
                    "id": 108,
                    "name": "Text exam"
                }
            ],
            "expert": [
                {
                    "id": 114,
                    "name": "Extra markup exam"
                }
            ]
        }
    }
}
```

**6. Get /css аналогично**

**7. Get /forum/preview запрос для вывода списка тегов навигации**

Вывод:

```
{
    "result": {
    "code": 0,
    "message": "No error"
},
"payload": [
    {
    "id": 0,
    "hashTagName": "JAVA",
    "title": "TITLE",
    "link": "/java",
    "lastDateUpdateArticles": 6,
    "numberOfArticles": 3
}
```

**8. Post /forum/article - вывод статей форума 

Вход:

+ Integer hashTagId; - фильтр для поиска по тэгу

Выход:

```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": [
        {
            "id": 10,
            "authorId": 2,
            "nickname": "Pavel",
            "title": "How props working?",
            "article": "I don't understand how props work. Please help me.",
            "dateCreated": "2020-11-25 11:00:00",
            "hoursAfter": 9,
            "daysAfter": 7,
            "hashTagId": 2,
            "hashTagName": "WEB",
            "likes": 0,
            "views": 0,
        }
    ]
}
```

**9. Post /forum/addArticle - добавление статьи на форум**

Вход: 

+ Integer authorId;
+ String title;
+ String article;
+ Integer hashTagId;

Вывод: 

```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": null
}
```

**10. Post /forum/addComment - добавление комментария к статье на форум**

Ввод:

+ Integer authorId;
+ Integer articleId;
+ String message;

Вывод:

```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": null
}
```

**11. Get /forum/comment/{articleId} - вывод всех комментариев по articleId

Вывод:  

```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": [
        {
            "id": 6,
            "authorId": 1,
            "nickname": "dezlo",
            "message": "so large",
            "likes": 0,
            "dateCreated": "2020-11-30 19:44:18",
            "hoursAfter": null,
            "daysAfter": null,
            "articleId": 17
        }
    ]
}
```
