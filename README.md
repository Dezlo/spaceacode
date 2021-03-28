# Backend spaceacode

##Auth

**1. Post /register**

Request:

+ String nickname
+ String email
+ String password

Response:

```
{
    "code": 0,
    "message": "No error"
}
```

**2. Post /auth**

Request параметры:

+ String login
+ String password

Response:
```
{
    "token": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkZXpsbzIxQHlhbmRleC5ydSIsImNsaWVudFR5cGUiOiJ1c2VyIiwibmlja25hbWUiOiJkZXpsbyIsInRva2VuX2V4cGlyYXRpb25fZGF0ZSI6MTU5OTE0MTczMTA3NywiZXhwIjoxNTk5MTQxNzMxLCJ1c2VySUQiOiIyOCIsImlhdCI6MTU5OTA1NTMzMSwianRpIjoiMjgiLCJ0b2tlbl9jcmVhdGVfZGF0ZSI6MTU5OTA1NTMzMTA3N30.miIqQL2ijkxOpkiqtrMn96bn7Y33iIny90RD9_UEz6E"
}
```

##Courses

**1. Get /html**

Response: 

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

**2. Get /css аналогично**


##Blog 

**1. Get /blog/articles**

Response:
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

**2.Post /blog/addArticle**

Request:

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

**3. Get /blog/likes/{articleId}**

Response: 

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

**4. Post /blog/like**

Request: 

+ Integer articleId;

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

##Forum

**1. Get /forum/articles/{hashTagId}** 
         
Response:
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

**2. Post /forum/addArticle**

Request: 

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

**3. Get /forum/comment/{articleId}**

Response:

```
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
            "message": "asf",
            "dateCreated": "2021-03-28 20:58:58",
            "timeAfter": "00:00:07.736709",
            "articleId": 2
        }
    ]
}
```

**4. Post /forum/addComment**

Request:

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

**5. Get /forum/preview**

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

**6. Get /forum/likes/{articleId}**

Response:

```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": [
        {
            "articleId": 2,
            "likes": 1,
            "isLiked": 1
        }
    ]
}
```

**7. Post /forum/like**

Request:

+ Integer articleId;

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

**8. Get /forum/likes/comment/{commentId}**

Response:

```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": [
        {
            "articleId": 1,
            "likes": 1,
            "isLiked": 1
        }
    ]
}
```

**9. Post /forum/commentLike**

Request:

+ Integer commentId;

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

##Challenge

**1. Get /challenge**

Response:

```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": [
        {
            "id": 1,
            "hashTagId": 3,
            "title": "first challenge",
            "dateCreated": "2021-03-07 19:05:27",
            "timeInterval": "2021-03-07 21:05:27",
            "timeLeft": "-21 days -02:04:21.463489",
            "description": "description for first challenge"
        }
    ]
}
```

##Clan

**1. Get /clan/create**

Response:

```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": {
        "users": [
            {
                "id": 1,
                "nickname": "dezlo"
            }
        ],
        "clans": [
            {
                "id": 1,
                "title": "Clan name 1",
                "rating": 3
            }
        ]
    }
}
```

**2. Post /clan/create**

Request: 

+ String title

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

**3. Get /clan/create**

Response:

```
{
    "result": {
        "code": 0,
        "message": "No error"
    },
    "payload": [
        {
            "id": 3,
            "title": "Clan name 3",
            "count": 1
        }
    ]
}
```