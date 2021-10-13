<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/common/fixed-header.css">
<link rel="stylesheet" href="/resources/css/member/join-page.css">
<%@ include file="/WEB-INF/views/include/mediaquery.jsp" %>
<script defer src="/resources/js/include/header.js"></script>
</head>

<body>
<%@ include file="/WEB-INF/views/include/fixed-header.jsp" %>
<section class="container con-join-form">

 <form class="join-page" name="login", id="frm-join" action="/member/join" method="post">
 
   <h1 class="tit-join">회원가입</h1>      
      <!-- 개인약관오류 고치기   -->

   <h2 class="tit-agree"> ☞ 서비스 이용약관</h2>
    <div class="agree">
        <div tabindex="0"> 
       제1장 총칙<br><br>
       <br>제1조 (목적)<br>
        이 약관은 홈페이지 리틀카레스트이 제공하는 모든 서비스(이하 "서비스"라 합니다)를 이용함에 있어 이용자와 "리틀카레스트"간의 권리·의무 및 책임사항과 기타 필요한 사항을 정하는 데 목적이 있습니다.<br>
        <br>제2조 (약관의 효력 및 변경)<br>
        "리틀카레스트"은 귀하가 본 약관 내용에 동의하는 경우, "리틀카레스트"의 서비스 제공 행위 및 귀하의 서비스 사용 행위에 본 약관이 우선적으로 적용됩니다. "리틀카레스트"는 본 약관을 사전 고지 없이 변경할 수 있고, 변경된 약관은 이용자가 직접 확인할 수 있도록 서비스 화면에 공지하며, 공지와 동시에 그 효력이 발생됩니다. 이용자가 변경된 약관에 동의하지 않는 경우, 이용자는 본인의 회원등록을 취소(회원탈퇴)할 수 있으며 계속 사용의 경우는 약관 변경에 대한 동의로 간주됩니다.<br>
       <br>제3조 (약관 외 준칙)<br>
        이 약관에 명시되지 않은 사항에 대해서는 전기통신기본법, 전기통신사업법, 정보통신망이용촉진및정보보호등에관한법률, 방송통신심의위원회 심의규정, 정보통신 윤리강령, 프로그램 보호법 등 기타 대한민국의 관련법령과 상관습에 의합니다.<br>
        <br>제4조 (용어의 정의)<br>
        ① 이 약관에서 사용하는 용어의 정의는 다음과 같습니다.<br>
        1. 이용자 : 이 약관에 따라 "리틀카레스트"이 제공하는 서비스를 받는자<br>
          2. 가입 : “리틀카레스트”이 제공하는 신청서 양식에 해당 정보를 기입하고, 이 약관에 동의하여 서비스 이용계약을 완료시키는 행위<br>
      3. 회원 : "리틀카레스트"에 개인정보 등 관련 정보를 제공하여 회원등록을 한 자로서, 일반회원과 정부혁신담당 공직자 회원으로 나뉨<br>
      4. 비밀번호 : 이용자와 회원ID가 일치하는지를 확인하고 통신상의 자신의 비밀보호를 위하여 이용자 자신이 선정한 문자와 숫자의 조합<br>
      5. 이용해지 : "리틀카레스트" 또는 회원이 서비스 이용 이후 그 이용계약을 종료시키는 의사표시<br>
      ② 이 약관에서 사용하는 용어의 정의는 제1항에서 정하는 것을 제외하고는 관계법령 및 서비스별 안내에서 정하는 바에 의합니다.<br>
      
      <br><br>제2장 서비스 이용계약<br><br>
      <br>제5조 (이용계약의 성립)<br>
      이용계약은 이용자가 약관내용을 동의하고 "리틀카레스트"에서 제공하는 소정의 회원 가입신청 양식에서 요구하는 사항을 기록하여 가입을 완료한 후 "리틀카레스트"가 회원가입을 승낙하면 성립됩니다.<br>
      <br>제6조 (이용계약의 유보와 거절)<br>
      ① "리틀카레스트"은 다음 각 호에 해당하는 이용계약에 대하여는 그 제한 사유가 해소될 때까지 일부 서비스 이용을 제한하거나 가입을 제한할 수 있습니다.<br>
      1. 신청서의 내용이 허위(차명 등)인 것으로 판명되거나, 그러하다고 의심할만한 합리적인 사유가 발생할 경우<br>
      2. 사회의 안녕 질서 또는 미풍양속을 저해할 목적으로 신청한 경우<br>
      3. 기타 "리틀카레스트"" 정한 이용계약 요건에 미비 되었을 경우<br>
      ② "리틀카레스트은" 다음에 해당하는 경우 그 사유가 해소될 때까지 이용계약 성립을 유보할 수 있습니다.<br>
      1. 서비스 관련 제반 용량이 부족한 경우<br>
      2. 기술상 장애 사유가 있는 경우<br>
      <br>제7조 (계약사항의 변경)<br>
      회원은 회원정보관리를 통해 언제든지 자신의 정보를 열람하고 수정할 수 있습니다. 회원은 이용신청 시 기재한 사항이 변경되었을 때에는 수정을 하여야 하며, 수정하지 아니하여 발생하는 문제의 책임은 회원에게 있습니다.<br>
      <br>제8조 (회원정보 사용에 대한 동의)<br>
      ① 회원의 개인정보는 [공공기관의 개인정보보호에 관한 법률]에 의해 보호됩니다.<br>
      ② 회원 정보는 다음과 같이 사용, 관리, 보호됩니다.<br>
      1. “리틀카레스트”은 서비스 제공과 관련해서 수집된 회원의 신상정보를 본인의 승낙 없이 제3자에게 누설, 배포하지 않습니다. 단, 전기통신기본법 등 법률의 규정에 의해 국가기관의 요구가 있는 경우, 범죄에 대한 수사상의 목적이 있거나 정보통신윤리위원회의 요청이 있는 경우 또는 기타 관계법령에서 정한 절차에 따른 요청이 있는 경우, 귀하가 “리틀카레스트”에 제공한 개인정보를 스스로 공개한 경우에는 그러하지 않습니다.<br>
      2. 개인정보의 관리 : 귀하는 개인정보의 보호 및 관리를 위하여 서비스의 개인정보관리에서 수시로 귀하의 개인정보를 수정/삭제할 수 있습니다.<br>
      3. 개인정보의 보호 : 귀하의 개인정보는 오직 귀하만이 열람/수정/삭제 할 수 있으며, 이는 전적으로 귀하의 ID와 비밀번호에 의해 관리되고 있습니다. 따라서 타인에게 본인의 ID와 비밀번호를 알려주어서는 안되며, 작업 종료시에는 반드시 로그아웃 하고 웹브라우저의 창을 닫아주시기 바랍니다<br>
      4. 회원이 이 약관에 따라 이용신청을 하는 것은, 신청서에 기재된 회원정보를 "리틀카레스트"이 수집, 이용하는 것에 동의하는 것으로 간주됩니다.<br>
      
      <br><br>제3장 서비스 제공 및 이용<br><br>
      <br>제9조 (서비스 이용)<br>
      ① "리틀카레스트"이 회원의 이용신청을 수락한 때부터 서비스를 개시합니다. 단, 일부 서비스의 경우에는 지정된 일자부터 서비스를 개시합니다.<br>
      ② 서비스의 이용 시간은 연중무휴 1일 24시간을 원칙으로 합니다. 다만, "리틀카레스트"의 업무상 또는 기술상의 이유, 정기점검 등으로 서비스가 일시 중지될 수 있습니다. 이러한 경우 "리틀카레스트"은 사전 또는 사후에 이를 공지합니다.<br>
      ③ 회원에 가입한 후라도 일부 서비스 이용 시 서비스 제공자의 요구에 따라 특정 회원에게만 서비스를 제공할 수도 있습니다.<br>
      ④"리틀카레스트"은 서비스를 일정범위로 분할하여 각 범위별로 이용가능 시간을 별도로 정할 수 있습니다. 이 경우 그 내용을 사전에 공지합니다.<br>
      제10조 (서비스의 변경, 중지 및 정보의 저장과 사용)<br>
      ① 이용자는 "리틀카레스트"에 보관되거나 전송된 메시지 및 기타 통신 메시지 등의 내용이 국가의 비상사태, 정전, "리틀카레스트"의 관리범위 외의 서비스 설비 장애 및 기타 불가항력에 의하여 보관되지 못하였거나 삭제된 경우, 전송되지 못한 경우 및 기타 통신 데이터의 손실에 대해 "리틀카레스트"이 아무런 책임을 지지 않음에 동의합니다.<br>
      ② "리틀카레스트"이 정상적인 서비스 제공의 어려움으로 인하여 일시적으로 서비스를 중지하여야 할 경우에는 서비스 중지 1주일 전에 고지 후 서비스를 중지할 수 있으며, 이 기간동안 회원이 고지내용을 인지하지 못한데 대하여 "정부혁신1번가"는 책임을 부담하지 아니합니다. 부득이한 사정이 있을 경우 위 사전 고지기간은 감축되거나 생략될 수 있습니다. 또한 위 서비스 중지에 의하여 본 서비스에 보관되거나 전송된 메시지 및 기타 통신 메시지 등의 내용이 보관되지 못하였거나 삭제된 경우, 전송되지 못한 경우 및 기타 통신 데이터의 손실이 있을 경우에 대하여도 "정부혁신1번가"는 책임을 부담하지 아니합니다.<br>
      ③ "리틀카레스트"이 사전 고지 후 서비스를 일시적으로 수정, 변경 및 중단할 수 있으며, 이에 대하여 회원 또는 제3자에게 어떠한 책임도 부담하지 아니합니다.
      ④ "리틀카레스트"의 사정으로 서비스를 영구적으로 중단하여야 할 경우 제2항을 준용합니다. 다만, 이 경우 사전 고지기간은 1개월로 합니다.<br>
      ⑤ "리틀카레스트"은 이용자가 이 약관의 내용에 위배되는 행동을 한 경우, 임의로 서비스 사용을 제한 및 중지할 수 있습니다. 이 경우 "리틀카레스트"은 이용자의 접속을 금지할 수 있으며, 이용자가 게시한 내용의 전부 또는 일부를 임의로 삭제할 수 있습니다.<br>
      ⑥ 장기간 휴면 회원인 경우 자체적으로 서비스 사용을 중지할 수 있습니다.<br>
      <br>제11조 (정보의 제공 및 광고의 게재)<br>
      ① "리틀카레스트"은 회원이 서비스 이용 중 필요가 있다고 인정되는 다양한 정보 및 광고에 대해서는 E-mail이나 서신우편물, 전화, SMS(휴대폰 문자메시지), 메신저 등의 방법으로 회원에게 제공할 수 있으며, 만약 원치 않는 정보를 수신한 경우 회원은 이를 수신거부 할 수 있습니다.<br>
      ② "리틀카레스트"은  서비스의 운용과 관련하여 서비스화면, 홈페이지, 전자우편 등에 홍보물 및 광고 등을 게재할 수 있으며, 서비스를 이용하고자 하는 회원 및 이용자가 이에 대하여 동의하는 것으로 간주합니다.<br>
      ③ "리틀카레스트"은  서비스 상에 게재되어 있거나 서비스를 통한 광고주와의 판촉활동에 회원이 참여하거나 교신 또는 거래의 결과로서 발생하는 모든 손실 또는 손해에 대해 책임을 지지 않습니다.<br>
      <br>제12조 (게시물 또는 내용물의 관리)<br>
      ①"리틀카레스트"은  회원이 게시하거나 등록하는 서비스 내의 내용물이 다음 각 호의 경우에 해당된다고 판단되는 경우 사전 통지 없이 삭제할 수 있으며, 이에 대해 "정부혁신1번가"는 어떠한 책임도 지지 않습니다.<br>
      1. "리틀카레스트"은  다른 회원 또는 제3자를 비방하거나 중상모략으로 명예를 손상시키는 내용인 경우<br>
      2. 공공질서 및 미풍양속에 위반되는 내용인 경우<br>
      3. 범죄적 행위에 결부된다고 인정되는 내용일 경우<br>
      4. 제3자의 저작권 등 기타 권리를 침해하는 내용인 경우<br>
      5. 서비스 성격에 부합하지 않는 정보의 경우<br>
      6. 이 약관에 위배되거나 상용 또는 불법, 음란, 저속하다고 판단되는 내용인 경우<br>
      7. 기타 관계 법령 에 위배되는 경우<br>
      ②"리틀카레스트"은  서비스 제공 목적에 부합할 경우 회원이 서비스에 게시한 내용을 사전 통지없이 편집 또는 이동할 수 있는 권리를 보유합니다.<br>
      ③"리틀카레스트"은  게시된 내용이 일정기간 이상 경과되어, 게시물로서의 효력을 상실하여 그 존치 목적이 불분명한 경우 해당 게시물을 삭제할 수 있습니다.<br>
      <br>제13조 (게시물의 저작권)<br>
      ① 회원이 서비스 내에 게시한 게시물의 저작권은 회원에게 있으며, "리틀카레스트"은  다른 서비스에서의 개재 등 서비스 내의 게시물을 활용할 수 있습니다.<br>
      ② 회원의 게시물이 타인의 저작권, 프로그램 저작권 등을 침해함으로써 발생하는 민, 형사상의 책임은 전적으로 회원이 부담하여야 합니다.<br>
      ③ 회원은 서비스를 이용하여 얻은 정보를 가공, 판매하는 행위 등 서비스에 게재된 자료를 상업적으로 사용할 수 없습니다.<br>
      <br>제14조 (""리틀카레스트"의 소유권)<br>
      ① "리틀카레스트"의 제공하는 서비스, 그에 필요한 소프트웨어, 이미지, 마크, 로고, 디자인, 서비스명칭, 정보 및 상표 등과 관련된 지적재산권 및 기타권리는 행정안전부에 소유권이 있습니다.<br>
      ② 회원은 "리틀카레스트" 또는 행정안전부가 명시적으로 승인한 경우를 제외하고는 제1항 소정의 각 재산에 대한 전부 또는 일부의 수정, 대여, 대출, 판매, 배포, 제작, 양도, 재라이센스, 담보권 설정행위, 상업적 이용행위를 할 수 없으며, 제3자로 하여금 이와 같은 행위를 하도록 허락할 수 없습니다.<br>
      
      <br><br>제4장 계약 당사자의 의무<br><br>
      <br>제15조 (회원의 의무 및 정보보안)<br>
      ① 회원이 서비스 사용을 위한 가입절차를 완료하시면 아이디와 비밀 번호를 받게 됩니다. 회원의 아이디, 비밀번호 관리를 위해 본인의 승인 없이 비밀번호, 아이디가 사용되는 문제가 발생되면 즉시 "리틀카레스트"에 신고하셔야 합니다.<br>
      ② 회원은 서비스를 이용하면서 다음과 같은 행위를 하지 않기로 동의합니다.<br>
      1. 타인의 아이디와 비밀번호를 도용하거나 타인으로 가장하는 행위<br>
      2. 타인과의 관계를 허위로 명시하는 행위<br>
      3. 타인을 비방할 목적으로 사실 또는 허위의 사실을 적시하여 명예를 훼손하는 행위<br>
      4. 자기 또는 타인에게 재산상의 이익을 주거나 타인에게 손해를 가할 목적으로 허위의 정보를 유통시키는 행위<br>
      5. 수치심이나 혐오감 또는 공포심을 일으키는 말이나 음향, 글이나 화상 또는 영상을 계속하여 상대방에게 도달하게 하여 상대방의 일상적 생활을 방해하는 행위<br>
      6. "리틀카레스트”의 사전 승낙 없이 서비스를 이용한 영리행위<br>
      7. 타인의 정보통신서비스 이용명의를 도용하여 사용하는 행위<br>
      8. 불필요하거나 승인되지 않은 광고, 판촉물을 게재하거나, "정크 메일(junk mail)", "스팸(spam)", "행운의 편지(chain letters)", "도배글", "피라미드 조직" 등을 권유하거나 게시, 게재 또는 E-mail로 보내는 행위<br>
      9. 저속 또는 음란한 데이터, 텍스트, 소프트웨어, 음악, 사진, 그래픽, 비디오 메시지 등(이하 "콘텐츠")을 게시, 게재 또는 E-mail로 보내는 행위<br>
      10 권리(지적재산권을 포함한 모든 권리)가 없는 콘텐츠를 게시, 게재 또는 E-mail로 보내는 행위<br>
      11 컴퓨터 소프트웨어, 하드웨어, 전기통신 장비를 파괴, 방해 또는 기능을 제한하기 위한 소프트웨어 바이러스를 게시, 게재 또는 E-mail로 보내는 행위<br>
      12 다른 컴퓨터 코드, 파일, 프로그램을 포함하고 있는 자료를 게시, 게재, E-mail로 보내는 행위 등 다른 사용자의 개인정보를 수집 또는 저장하는 행위<br>
      13. 재물을 걸고 도박하거나 사행행위를 하는 행위<br>
      14 윤락행위를 알선하거나 음행을 매개하는 내용의 정보를 유통시키는 행위<br>
      15 기타 불법적이거나 부당한 행위<br>
      ③ 회원은 이 약관 및 관계법령에서 규정한 사항을 준수하여야 합니다.<br>
      <br>제16조 ("리틀카레스트”의 의무)<br>
      ① "리틀카레스트"의 이 약관에서 정한 바에 따라 계속적, 안정적인 서비스를 제공하기 위하여 노력할 의무가 있습니다.<br>
      ② "리틀카레스트"의 제공하는 서비스로 인하여 회원에게 손해가 발생한 경우 그러한 손해가 "리틀카레스트"의 고의나 중과실에 기해 발생한 경우에 한하여 "정부혁신1번가"에서 책임을 부담하며, 그 책임의 범위는 통상손해에 한합니다.<br>
      ③ "리틀카레스트"의 회원으로부터 제기되는 의견이나 불만이 정당하다고 인정할 경우에는 신속히 처리하여야 합니다. 다만, 신속한 처리가 곤란한 경우에는 회원에게 그 사유와 처리일정을 통보하여야 합니다.<br>
      ④ "리틀카레스트"는 관련법령이 정하는 바에 따라서 회원 등록정보를 포함한 회원의 개인정보를 보호하기 위하여 노력합니다. 회원의 개인정보보호에 관해서는 관련법령 및 제 8조와 제 16조에 제시된 내용을 지킵니다.<br>
      <br>제17조 (개인정보보호정책)<br>
      ①"리틀카레스트"의 이용 신청 시 회원이 제공하는 정보를 통하여 회원에 관한 정보를 수집하며, 회원의 개인정보는 본 이용계약의 이행과 본 이용계약상의 서비스제공을 위한 목적으로 이용합니다.<br>
      ②"리틀카레스트"는 서비스 제공과 관련하여 취득한 회원의 정보를 본인의 승낙 없이 제3자에게 누설 또는 배포할 수 없으며 상업적 목적으로 사용할 수 없습니다. 다만, 다음의 각 호의 경우에는 그러하지 아니합니다.<br>
      1. 관계 법령에 의하여 수사상의 목적으로 관계기관으로부터 요구가 있는 경우<br>
      2. 방송통신심의위원회의 요청이 있는 경우<br>
      3. 기타 관계법령에서 정한 절차에 따른 요청이 있는 경우<br>
      
      
      <br><br>제5장 계약해지<br><br>
      <br>제18조 (계약해지 및 이용제한)<br>
      ① 회원이 이용계약을 해지하고자 하실 때에는 회원 본인이 직접 인터넷을 통해 당 사이트에 해지 신청을 하여야 합니다.<br>
      ② "리틀카레스트"의 보안 및 아이디 정책, 서비스의 원활한 제공 등과 같은 이유로 회원의 아이디 및 비밀번호 변경을 요구하거나 변경 할 수 있습니다.<br>
      ③ "리틀카레스트"은 회원이 다음 각 호에 해당하는 행위를 하였을 경우 사전통지 없이 이용계약을 해지할 수 있습니다.<br>
      1. 회원이 제공한 데이터가 허위임이 판명된 경우<br>
      2. 범죄적 행위에 관련되는 경우<br>
      3. 국익 또는 사회적 공익을 저해할 목적으로 서비스 이용을 계획 또는 실행할 경우<br>
      4. 타인의 서비스 아이디 및 비밀 번호를 도용한 경우<br>
      5. 타인의 명예를 손상시키거나 불이익을 주는 경우<br>
      6. 서비스에 위해를 가하는 등 서비스의 건전한 이용을 저해하는 경우<br>
      7. 기타 관련법령이나 보다나은정부 상디트가 정한 이용조건에 위배되는 경우<br>
      <br><br>제6장 기타<br><br>
      <br>제19조 (요금 및 유료정보)<br>
      서비스 이용은 기본적으로 무료입니다. 단, 필요시 별도의 유료 정보와 유료서비스를 제공할 수 있습니다.<br>
      <br>제20조 (양도금지)<br>
      회원은 서비스의 이용권한, 기타 이용계약상의 지위를 타인에게 양도, 증여할 수 없으며, 이를 담보로 제공할 수 없습니다.<br>
      <br>제21조 (손해배상)<br>
      "리틀카레스트"은 무료로 제공되는 서비스와 관련하여 회원에게 어떠한 손해가 발생하더라도 동 손해가 "리틀카레스트"의 중대한 과실에 의한 경우를 제외하고 이에 대하여 책임을 부담하지 아니합니다.<br>
      <br>제22조 (면책조항)<br>
      ① "리틀카레스트"은 천재지변 또는 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우, 기간통신 사업자가 전기통신 서비스를 중지하거나 정상적으로 제공하지 아니하여 손해가 발생한 경우, 서비스용 설비의 보수, 교체, 정기점검, 공사 등 부득이한 사유로 손해가 발생한 경우에는 서비스 제공에 관한 책임이 면제됩니다.<br>
      ② "리틀카레스트"은 회원의 귀책사유로 인한 서비스 이용의 장애에 대하여 책임을 지지 않습니다.<br>
      ③ "리틀카레스트"은 회원이나 제3자에 의해 표출된 어떠한 의견이나 정보에 대해 확신이나 대표할 의무가 없으며 의견을 승인하거나 반대하거나 수정하지 않습니다.<br>
      ④ "리틀카레스트"은 회원 또는 기타 유관기관이 서비스에 게재한 정보, 자료, 사실의 신뢰도, 정확성 등에 관하여 보장하지 않습니다.<br>
      ⑤ "리틀카레스트"은 회원이 서비스를 이용하여 기대하는 이익이나 서비스를 통하여 얻은 자료로 인한 일체의 손실이나 손해에 관하여 책임을 지지 않습니다.<br>
      ⑥ "리틀카레스트"은 이용자가 서비스 이용과 관련하여 이용자간에 발생한 손해 중 이용자의 고의, 과실에 의한 손해 및 타 이용자로 인하여 입게 되는 정신적 피해에 대하여 보상할 책임지지 않습니다.<br>
      제23조 (관할법원)<br>
      ① 서비스 이용과 관련하여 "리틀카레스트"은 회원 사이에 분쟁이 발생한 경우,"리틀카레스트"은 회원은 발생한 분쟁을 원만하게 해결하기 위하여 필요한 모든 노력을 하여야 합니다<br>
      ② 제1항의 규정에도 불구하고 서비스 이용으로 발생한 분쟁에 대하여 소송이 제기될 경우 "리틀카레스트" 소재지를 관할하는 법원을 관할법원으로 합니다.<br>
      부 칙<br>
      ① 이 약관은 2021년 10월 04일부터 적용합니다.<br>
      .<br>       
        </div>
        <p>
           <input type="checkbox" id="chk1" class="check" required>
           <label for="chk1" title="약관에 동의하셔야  회원가입이 가능합니다.">홈페이지  이용약관에 동의합니다.(필수)</label>
        </p>
    </div>
    <br>
    <h2 class="tit-agree"> ☞ 개인정보 수집·이용 동의</h2>
    <div class="agree">
        <div tabindex="0">
      <br>개인정보보호정책<br>
     <br>리틀카레스트의 이용을 위해 수집한 귀하의 정보를 관리함에 있어서 「개인정보보호법」에서 규정하고 있는 책임과 의무를 준수하고 제공자가 동의한 내용 외 다른 목적으로는 활용하지 않음을 알려드립니다.<br>
      - 개인정보 수집이용 목적 : 회원가입 및 본인인증,기타 서비스 제공 등<br>
      - 수집하려는 개인정보 항목<br>
      <br>* 리틀카레스트 회원의 경우<br>
      - 필수 : 아이디, 비밀번호, 닉네임, 생년월일,이메일<br>
      <br>* 리틀카레스트 카카오 SNS계정 인증가입의 경우<br>
      - 필수 : 아이디, 성명<br>
      - 개인정보 보유 및 이용기간 : 개인정보 및  이용목적이 달성된 후에는 지체 없이 파기합니다. 개인정보 보유 및 이용기간은 회원 탈퇴 시까지입니다.
      - 이용자는 "리틀카레스트"에서 수집하는 개인정보 제공에 대한 동의를 거부할 권리가 있습니다. 다만, 리틀카레스트 이용에 필요한 필수 항목의 제공에 대한 동의를 거부하시면 위의 서비스가 제한될 수 있습니다.
        </div>
        <p>
           <input type="checkbox" id="chk2" class="check" required>
           <label for="chk2">개인정보 수집·이용 동의 이용약관에 동의합니다.(필수)</label>
        </p>
    </div>

    
    <br><br>
    <div>
       <h3>아이디</h3>
       <input type="text" id="userId" name="userId" size="10" placeholder="아이디를 입력하세요" 
     		<c:if test="${not empty param.err and empty joinValid.userId}">
 					value="${joinForm.userId}"
                </c:if>
                 required/>
        

          <button class="btn" id="idcheck">중복확인</button>
 	    <h1 class="valid-msg" id="id-check" style="text-align: left;">
        		<c:if test="${not empty param.err and not empty joinValid.userid}">
        		이미 존재하는 아이디 입니다.
       		 </c:if>
        </h1>
 	</div>


   <div>
      <h3>비밀번호</h3>
      <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요."
      <c:if test="${not empty param.err and empty joinValid.password}">
 					value="${joinForm.password}"
                </c:if>
       required/>
      <div>     
        <c:if test="${not empty param.err and not empty joinValid.password}">
        <span class="valid-msg">
        	영어,숫자,특수문자 조합의 8글자 이상입니다.
        </span>
        </c:if>
      </div>

   </div>
   <div>
      <h3>비밀번호확인</h3>
      <input type="password" id="chkPwd" name="chkPwd" required placeholder="비밀번호를 입력하세요."/>
		<div>
	        <c:if test="${not empty param.err and not empty joinValid.confirmPassword}">
	        <span class="valid-msg">
	        	비밀번호가 일치하지 않습니다.
	        </span>    	
	        </c:if>
	   </div>
  </div>
  <div>
      <h3>닉네임</h3>
      <input type="text" name="nickname" id="nickname"  required />
      <button class="btn" id="checkNickname">닉네임확인</button>
       <div>
	       <c:if test="${not empty param.err and not empty joinValid.nickname}">
	       <span class="valid-msg">
		        이미 존재하는 닉네임 입니다.
		   </span>
	       </c:if>
       </div>      
   </div>

   <div>
      <h3>생년월일</h3>
     <div class="birth">
          <select name="birth" id="birth" required>
           <option value="">년도</option>
           <option value="2021">2021</option>
           <option value="2020">2020</option>
           <option value="2019">2019</option>
           <option value="2018">2018</option>
           <option value="2017">2017</option>
           <option value="2016">2016</option>
           <option value="2015">2015</option>
           <option value="2014">2014</option>
           <option value="2013">2013</option>
           <option value="2012">2012</option>
           <option value="2011">2011</option>
           <option value="2010">2010</option>
           <option value="2009">2009</option>
           <option value="2008">2008</option>
           <option value="2007">2007</option>
           <option value="2006">2006</option>
           <option value="2005">2005</option>
           <option value="2004">2004</option>
           <option value="2003">2003</option>
           <option value="2002">2002</option>
           <option value="2001">2001</option>
           <option value="2000">2000</option>
           <option value="1999">1999</option>
           <option value="1998">1998</option>
           <option value="1997">1997</option>
           <option value="1996">1996</option>
           <option value="1995">1995</option>
           <option value="1994">1994</option>
           <option value="1993">1993</option>
           <option value="1992">1992</option>
           <option value="1991">1991</option>
           <option value="1990">1990</option>
           <option value="1989">1989</option>
           <option value="1988">1988</option>
           <option value="1987">1987</option>
           <option value="1986">1986</option>
           <option value="1985">1985</option>
           <option value="1984">1984</option>
           <option value="1983">1983</option>
           <option value="1982">1982</option>
           <option value="1981">1981</option>
           <option value="1980">1980</option>
           <option value="1979">1979</option>
           <option value="1978">1978</option>
           <option value="1977">1977</option>
           <option value="1976">1976</option>
           <option value="1975">1975</option>
           <option value="1974">1974</option>
           <option value="1973">1973</option>
           <option value="1972">1972</option>
           <option value="1971">1971</option>
           <option value="1970">1970</option>
           <option value="1969">1969</option>
           <option value="1968">1968</option>
           <option value="1967">1967</option>
           <option value="1966">1966</option>
           <option value="1965">1965</option>
           <option value="1964">1964</option>
           <option value="1963">1963</option>
           <option value="1962">1962</option>
           <option value="1961">1961</option>
           <option value="1960">1960</option>
           <option value="1959">1959</option>
           <option value="1958">1958</option>
           <option value="1957">1957</option>
           <option value="1956">1956</option>
           <option value="1955">1955</option>
           <option value="1954">1954</option>
           <option value="1953">1953</option>
           <option value="1952">1952</option>
           <option value="1951">1951</option>
           <option value="1950">1950</option>
           <option value="1949">1949</option>
           <option value="1948">1948</option>
           <option value="1947">1947</option>
           <option value="1946">1946</option>
           <option value="1945">1945</option>
           <option value="1944">1944</option>
           <option value="1943">1943</option>
           <option value="1942">1942</option>
           <option value="1941">1941</option>
           <option value="1940">1940</option>
           <option value="1939">1939</option>
           <option value="1938">1938</option>
           <option value="1937">1937</option>
           <option value="1936">1936</option>
           <option value="1935">1935</option>
           <option value="1934">1934</option>
           <option value="1933">1933</option>
           <option value="1932">1932</option>
           <option value="1931">1931</option>
           <option value="1930">1930</option>
           <option value="1929">1929</option>
           <option value="1928">1928</option>
           <option value="1927">1927</option>
           <option value="1926">1926</option>
           <option value="1925">1925</option>
           <option value="1924">1924</option>
           <option value="1923">1923</option>
           <option value="1922">1922</option>
           <option value="1921">1921</option>
         </select>
         <select name="month" id="morth" required>
           <option value="">-- 선택 --</option>
           <option value="1">1</option>
           <option value="2">2</option>
           <option value="3">3</option>
           <option value="4">4</option>
           <option value="5">5</option>
           <option value="6">6</option>
           <option value="7">7</option>
           <option value="8">8</option>
           <option value="9">9</option>
           <option value="10">10</option>
           <option value="11">11</option>
           <option value="12">12</option>
         </select>
         <select name="day" id="day" required>
           <option value="">-- 선택 --</option>
           <option value="1">1</option>
           <option value="2">2</option>
           <option value="3">3</option>
           <option value="4">4</option>
           <option value="5">5</option>
           <option value="6">6</option>
           <option value="7">7</option>
           <option value="8">8</option>
           <option value="9">9</option>
           <option value="10">10</option>
           <option value="11">11</option>
           <option value="12">12</option>
           <option value="13">13</option>
           <option value="14">14</option>
           <option value="15">15</option>
           <option value="16">16</option>
           <option value="17">17</option>
           <option value="18">18</option>
           <option value="19">19</option>
           <option value="20">20</option>
           <option value="21">21</option>
           <option value="22">22</option>
           <option value="23">23</option>
           <option value="24">24</option>
           <option value="25">25</option>
           <option value="26">26</option>
           <option value="27">27</option>
           <option value="28">28</option>
           <option value="29">29</option>
           <option value="30">30</option>
           <option value="31">31</option>
         </select>
   </div>
  </div>

   <div>
      <h3>이메일</h3>
      <c:if test="true">
         <span></span>
      </c:if>
      <input type="email" id="email" name="email" placeholder="이메일을 입력하세요." 
      	<c:if test="${not empty param.err and empty joinValid.email}">
 					value="${joinForm.email}"
                </c:if>
      required />      
   </div>

      <button id="join" type="submit" onclick="fn-check()">가입하기</button>

 </form>       
 <%@ include file="/WEB-INF/views/include/footer.jsp" %>
</section>

<script type="text/javascript" src="/resources/js/member/joinForm.js">
     
     
     function fn_check() {
    	 if(document.login.chk1.checked == false ||
    		document.login.chk2.checked == false) {
    		 alert("약관에 동의해주세요")
 			return false; 	
	
     }
       location = "http://localhost:7070";
      
     }
     
     
     
     
     $(function () {
    	 chk1_CheckedChanged();	 
     });
     
     //체크박스 체크 선택 또는 해제시 상태 확인 업데이트
     $("#chk1").chage(function() {
    	 chk1_CheckedChanged();
     }); 
     
     function chk1_CheckedChanged() {
 		if($("#chk1").prop("checked")){
			closole.log("체크");	
			$("#join").prop("disabled", false);
		}
		else{
			console.log("언체크");ㅣ
			$("#join").prop("disabled", true);
			
		}		
	}
    	 
    	 
   
	
     
     
     
     
     
</script>
</body>
</html>