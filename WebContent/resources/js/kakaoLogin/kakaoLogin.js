Kakao.init('b48910cb5f06aa478cc2184431f97be9');
function loginFormWithKakao() {
    Kakao.Auth.loginForm({
             success : function(authObj) {
                Kakao.Auth.login({
                         scope : 'profile_nickname,account_email,gender',
                         success : function(e) {
                            console.dir(e)
                            Kakao.API.request({
                                     url : '/v2/user/me',
                                     success : function(res) {
                              fetch('/member/kakao-login?userId='  + res.id)
                              .then(response => {
                                 if(response.ok){
                                    /*console.dir(response.status);
                                    console.dir('통신성공' + res.id);
                                    console.dir(response.text());*/
                                    return response.text();

                                 }else{
                                    throw new Error(response.status);
                                 }
                                 
                              }).then(text => {
                                 if(text == 'kakaoLogin'){
                                    console.dir('로그인성공');
                                    location.href = '/index';
                                 }else if(text == 'kakaoJoin'){   
                                    console.dir('가입하러가기');               
                                    location.href = '/member/kakao-join-page?userId='+res.id;      
                                 }
                              }).catch(error => {
                                 alert(error + '응답에 실패하였습니다.');
                              })
                              
                                           
                                     },fail : function(error) {
                                        alert('login success, but failed to request user information: '
                                              + JSON.stringify(error))
                                     }
                                  })
                         },fail : function(error) {
                            console.dir(error)
                         },

                      })

             },fail : function(err) {
                showResult(JSON.stringify(err))
             },
          })
 }