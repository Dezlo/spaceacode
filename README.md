# Backend spaceacode

**1. Post /register**

Requestные праметры:

+ String nickname
+ String email
+ String password

**Email должен быть всегда уникальным**

Ответ:

```
{
    "code": 0,
    "message": "No error"
}
```

**2. Post /auth**

Requestные параметры:

+ String login
+ String password

Ответ:
```
{
    "token": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkZXpsbzIxQHlhbmRleC5ydSIsImNsaWVudFR5cGUiOiJ1c2VyIiwibmlja25hbWUiOiJkZXpsbyIsInRva2VuX2V4cGlyYXRpb25fZGF0ZSI6MTU5OTE0MTczMTA3NywiZXhwIjoxNTk5MTQxNzMxLCJ1c2VySUQiOiIyOCIsImlhdCI6MTU5OTA1NTMzMSwianRpIjoiMjgiLCJ0b2tlbl9jcmVhdGVfZGF0ZSI6MTU5OTA1NTMzMTA3N30.miIqQL2ijkxOpkiqtrMn96bn7Y33iIny90RD9_UEz6E"
}
```

**3. Get /blog/articles**

Ответ:
 ```
{
    {
        "result": {
            "code": 0,
            "message": "No error"
        },
        "payload": [
            {
                "id": 1,
                "authorId": 1,
                "nickname": "dezlo",
                "title": "The intrigue with the iPhone 12 is discussed on the web at today's Apple presentation",
                "article": "In the evening, at 20:00 Moscow time, the long-awaited Apple presentation will take place...",
                "dateCreated": "2021-03-07 19:05:26",
                "timeAfter": "16 days 23:03:52.649276",
                "hashTagId": 2,
                "hashTagName": "WEB",
                "views": 9
            }
        ]
    }
}
```

**4.Post /blog/addArticle**

Request:

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

**6. Get /blog/likes/{articleId}**

Выход: 

```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": [
        {
            "articleId": 3,
            "likes": 1,
            "isLiked": 1
        }
    ]
}
```

**7. Post /blog/like**

Request: 

+ Integer articleId;

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

**7. Get /forum/preview**

Response:

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
            "lastDateUpdateArticles": "16 days 23:08:55.517098",
            "numberOfArticles": 3
        },
```

**8. Get /forum/articles/{hashTagId} 

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

Request: 

+ Integer authorId;
+ String title;
+ String article;
+ Integer hashTagId;

Response: 

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

Response:

```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": null
}
```

**11. Get /forum/comment/{articleId} - Response всех комментариев по articleId

Response:  

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
