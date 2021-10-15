<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<style type="text/css">
    @media screen {
        @font-face {
        font-family: 'Noto Sans KR';
        font-style: normal;
        font-weight: 100;
        src: url(/fonts/NotoSansKr/NotoSansKR-Thin.woff2) format('woff2'),
            url(/fonts/NotoSansKr/NotoSansKR-Thin.woff) format('woff'),
            url(/fonts/NotoSansKr/NotoSansKR-Thin.otf) format('opentype');
                    }
        @font-face {
        font-family: 'Noto Sans KR';
        font-style: normal;
        font-weight: 300;
        src: url(/fonts/NotoSansKr/NotoSansKR-Light.woff2) format('woff2'),
            url(/fonts/NotoSansKr/NotoSansKR-Light.woff) format('woff'),
            url(/fonts/NotoSansKr/NotoSansKR-Light.otf) format('opentype');
        }
        @font-face {
        font-family: 'Noto Sans KR';
        font-style: normal;
        font-weight: 400;
        src: url(/fonts/NotoSansKr/NotoSansKR-Regular.woff2) format('woff2'),
                url(/fonts/NotoSansKr/NotoSansKR-Regular.woff) format('woff'),
                url(/fonts/NotoSansKr/NotoSansKR-Regular.otf) format('opentype');
        }
        @font-face {
        font-family: 'Noto Sans KR';
        font-style: normal;
        font-weight: 500;
        src: url(/fonts/NotoSansKr/NotoSansKR-Medium.woff2) format('woff2'),
                url(/fonts/NotoSansKr/NotoSansKR-Medium.woff) format('woff'),
                url(/fonts/NotoSansKr/NotoSansKR-Medium.otf) format('opentype');
        }
        @font-face {
        font-family: 'Noto Sans KR';
        font-style: normal;
        font-weight: 700;
        src: url(/fonts/NotoSansKr/NotoSansKR-Bold.woff2) format('woff2'),
                url(/fonts/NotoSansKr/NotoSansKR-Bold.woff) format('woff'),
                url(/fonts/NotoSansKr/NotoSansKR-Bold.otf) format('opentype');
        }
        @font-face {
        font-family: 'Noto Sans KR';
        font-style: normal;
        font-weight: 900;
        src: url(/fonts/NotoSansKr/NotoSansKR-Black.woff2) format('woff2'),
                url(/fonts/NotoSansKr/NotoSansKR-Black.woff) format('woff'),
                url(/fonts/NotoSansKr/NotoSansKR-Black.otf) format('opentype');
        } 
        }

    body {
        background-color: #f4f4f4 ;
        font-family: 'Noto Sans KR', sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100%;
    }

</style>
</head>

<body>

    <div style="display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Noto Sans KR', sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;"> We're thrilled to have you here! Get ready to dive into your new account. </div>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
        <!-- LOGO -->
        <tr>
            <td bgcolor="#f4f4f4" align="center">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                    <tr>
                        <td align="center" valign="top" style="padding: 40px 10px 40px 10px;"> </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td bgcolor="#f4f4f4" align="center" style="padding: 0px 20px;">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                    <tr>
                        <td bgcolor="#ffffff" align="center" valign="top" style="padding: 0px;  color: #2a2a2a; font-family: 'Noto Sans KR', sans-serif; font-size: 48px; line-height: 48px;">
                            <h1 style="font-size: 33px; font-weight: 600; margin: 50px; margin-bottom: 0;">${param.userId}님</h1>
                            <h1 style="font-size: 33px; font-weight: 600; margin: 0;"><span style="color: #1c1350;">풋살온</span> 가입을 환영합니다!</h1>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr >
            <td bgcolor="#f4f4f4" align="center" style="padding: 0px 20px; ">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                    <tr>
                        <td bgcolor="#ffffff" align="left">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td bgcolor="#ffffff" align="center" style=" padding: 20px 30px 60px 30px; " >
                                        <table border="0" cellspacing="0" cellpadding="0"  style="border-radius: 0px 0px 12px 12px;">
                                            <tr>
                                                <td align="center" style="border-radius: 12px; background:linear-gradient(45deg, #000, #1c1350, #000);" >
                                                <a href="http://localhost:7070/member/join-impl?persist-token=${param.persistToken}" target="_blank" style="font-size: 22px; color: #ffffff; text-decoration: none; padding: 15px 25px; font-weight: 600; border-radius: 13px; display: inline-block ; line-height: 25px;">
                                                 버튼을 클릭해 회원가입을 완료하세요
                                                 <a>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#f4f4f4" align="center">
                            <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                                <tr>
                                    <td align="center" valign="top" style="padding: 40px 10px 40px 10px;"> </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</body>

</html>