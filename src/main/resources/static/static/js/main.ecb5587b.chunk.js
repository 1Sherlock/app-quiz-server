(this["webpackJsonpapp-quiz-client"]=this["webpackJsonpapp-quiz-client"]||[]).push([[0],{424:function(e,s,i){},427:function(e,s,i){},428:function(e,s,i){"use strict";i.r(s);var c=i(2),t=i(15),a=i.n(t),n=i(1),l=function(){return Object(n.jsx)("div",{className:"top-navbar",children:Object(n.jsx)("div",{className:"container",children:Object(n.jsxs)("div",{className:"row",children:[Object(n.jsxs)("div",{className:"top-navbar-logo",children:[Object(n.jsx)("img",{src:"/img/icon/gerb.png",alt:""}),Object(n.jsxs)("h1",{children:["xorijiy tillarni o'rganishni ",Object(n.jsx)("br",{}),"ommalashtirish Agentligi"]})]}),Object(n.jsxs)("div",{className:"top-search",children:[Object(n.jsx)("span",{className:"icon icon-search"}),Object(n.jsx)("input",{type:"text",placeholder:"Saytdan izlash"})]})]})})})},r=i(33),j=i(118),d=i.n(j),o=i(188),b="LOGIN",h="https://app-dostlik.herokuapp.com/api/",m="app-quiz-token",x=(localStorage.getItem(m),i(119)),O=i.n(x),g=i(54);function p(e){return{type:b,payload:e}}function v(e,s){return function(i){O.a.post(h+"auth/signIn",e).then(function(){var e=Object(o.a)(d.a.mark((function e(c){return d.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(!c.data.accessToken){e.next=7;break}return e.next=3,localStorage.setItem(m,c.data.tokenType+" "+c.data.accessToken);case 3:i(p({loginModal:!1})),s.push("/edit"),e.next=8;break;case 7:g.b.error("Xatolik");case 8:case"end":return e.stop()}}),e)})));return function(s){return e.apply(this,arguments)}}()).catch((function(e){e.response&&(401===e.response.data.status?g.b.error("Bunday foydalanuvchi mavjud emas"):g.b.error("Xatolik"))}))}}var u=i(10),N=(i(407),i(28)),f=i(187),y=Object(r.b)((function(e){return{regstrModal:e.login.regstrModal,regstrModalNext:e.login.regstrModalNext,loginModal:e.login.loginModal,loginModalForgetPass:e.login.loginModalForgetPass}}),{updateState:p,LoginUser:v})((function(e){var s=Object(c.useState)(!1),i=Object(N.a)(s,2),t=i[0],a=i[1],l=function(){e.updateState({loginModal:!e.loginModal})},r=function(){e.updateState({loginModalForgetPass:!e.loginModalForgetPass}),e.updateState({loginModal:!1})};return Object(n.jsxs)("div",{children:[Object(n.jsx)(f.a,{isOpen:e.loginModal,className:"login-modal",toggle:l,children:Object(n.jsxs)("div",{className:"reg-form-login",children:[Object(n.jsx)("div",{className:"close-btn",children:Object(n.jsx)("button",{onClick:l,children:Object(n.jsx)("img",{src:"/img/icon/close.png"})})}),Object(n.jsx)("h2",{children:"Tizimga kirish"}),Object(n.jsxs)("div",{children:[Object(n.jsxs)(u.AvForm,{className:"form-group-val",onValidSubmit:function(s,i){e.LoginUser(i,e.history)},children:[Object(n.jsx)(u.AvField,{name:"login",placeholder:"Login  ",type:"text"}),Object(n.jsx)("div",{className:"half-region",children:Object(n.jsx)("div",{className:"row",children:Object(n.jsxs)("div",{className:"col-md-12",children:[Object(n.jsx)(u.AvField,{name:"password",placeholder:"Parol kiriting *",type:t?"text":"password"}),Object(n.jsx)("button",{type:"button",onClick:function(){a(!t)},children:t?Object(n.jsx)("img",{src:"/img/icon/Pass.png",alt:""}):Object(n.jsx)("img",{src:"/img/icon/showPass.png",alt:""})})]})})}),Object(n.jsx)("button",{className:"next-btn",children:"Tizimga kirish"})]}),Object(n.jsxs)("h6",{className:"forget-password",children:["Login yoki parolni ",Object(n.jsx)("button",{onClick:r,children:" unutdingizmi?"})]})]})]})}),Object(n.jsx)(f.a,{isOpen:e.loginModalForgetPass,children:Object(n.jsxs)("div",{className:"reg-form-login",children:[Object(n.jsx)("div",{className:"close-btn",children:Object(n.jsx)("button",{onClick:r,children:Object(n.jsx)("img",{src:"/img/icon/close.png"})})}),Object(n.jsx)("h2",{children:"Parolni qayta tiklash"}),Object(n.jsx)("div",{children:Object(n.jsxs)(u.AvForm,{className:"form-group-val",children:[Object(n.jsx)(u.AvField,{name:"teat",placeholder:"Telifon raqamani kiriting  ",type:"text"}),Object(n.jsx)("button",{className:"next-btn",children:"Kodini olish"})]})})]})})]})})),k=Object(r.b)((function(e){return{regstrModal:e.login.regstrModal,regstrModalNext:e.login.regstrModalNext,loginModal:e.login.loginModal,region:e.login.region,loginModalForgetPass:e.login.loginModalForgetPass}}),{updateState:p,getRegion:function(){return function(e){O.a.get(h+"region").then((function(s){e(p({region:s.data}))}))}},regstration:function(e){return function(s){s(p({firstDataForRegstration:e})),s(p({regstrModalNext:!0})),s(p({regstrModal:!1}))}},regstrationSecond:function(e){return function(s,i){s(p({firstDataForRegstration:e})),s(p({regstrModalNext:!0})),s(p({regstrModal:!1}))}},LoginUser:v})((function(e){var s=function(){e.updateState({regstrModal:!e.regstrModal})},i=Object(c.useState)(!1),t=Object(N.a)(i,2),a=t[0],l=t[1],r=Object(c.useState)(!1),j=Object(N.a)(r,2),d=j[0],o=j[1],b=Object(c.useState)(!1),h=Object(N.a)(b,2),m=(h[0],h[1],Object(c.useState)(!0)),x=Object(N.a)(m,2),O=x[0],g=(x[1],Object(c.useState)(!1)),p=Object(N.a)(g,2);p[0],p[1];var v=Object(c.useState)(!1),y=Object(N.a)(v,2),k=y[0],z=y[1],w=Object(c.useState)(!1),M=Object(N.a)(w,2),S=M[0],q=M[1],F=Object(c.useState)(!1),T=Object(N.a)(F,2),A=T[0],I=T[1];return Object(c.useEffect)((function(){})),Object(n.jsxs)("div",{children:[Object(n.jsx)(f.a,{isOpen:e.regstrModal,className:"regstr-modal",toggle:s,children:Object(n.jsxs)("div",{className:"reg-form",children:[Object(n.jsx)("div",{className:"close-btn",children:Object(n.jsx)("button",{onClick:s,children:Object(n.jsx)("img",{src:"/img/icon/close.png"})})}),Object(n.jsx)("h2",{children:"Ro\u2019yxatdan o\u2019tish"}),Object(n.jsxs)("div",{className:"top-line-group",children:[Object(n.jsx)("div",{className:"line-next",children:Object(n.jsx)("span",{children:"1"})}),Object(n.jsx)("div",{className:"min-line-one"}),Object(n.jsx)("span",{className:"title-one",children:"Identifikatsiya"}),Object(n.jsx)("div",{className:"center-line-two"}),Object(n.jsx)("div",{className:"line-next-two",children:Object(n.jsx)("span",{children:"2"})}),Object(n.jsx)("div",{className:"min-line-one"}),Object(n.jsx)("span",{className:"title-two",children:"Tasdiqlash"})]}),Object(n.jsx)("div",{children:Object(n.jsxs)(u.AvForm,{className:"form-group-val",onValidSubmit:function(s,i){e.regstration(i)},children:[Object(n.jsxs)("div",{className:O?" warning":" d-none  warning",children:[Object(n.jsx)("img",{src:"/img/icon/warning.png",alt:""}),Object(n.jsx)("p",{children:"Diqqat!!! Sertifikat tekshirishda muammo bo\u2019lmasligi uchun FIOni to\u2019gri kiriting."})]}),Object(n.jsxs)("div",{children:[Object(n.jsx)(u.AvField,{name:"fullName",onBlur:function(){z(!0)},placeholder:"FIO *",id:"bir1",type:"text"}),Object(n.jsx)("img",{src:"/img/icon/birdCircle.png",alt:"2",className:k?"bird-circle ":"d-none"})]}),Object(n.jsxs)("div",{children:[Object(n.jsx)(u.AvField,{name:"passport",onBlur:function(){q(!0)},placeholder:"Passport seriya va raqami *",type:"text"}),Object(n.jsx)("img",{src:"/img/icon/birdCircle.png",alt:"2",className:S?"bird-circle ":"d-none"})]}),Object(n.jsxs)("div",{children:[Object(n.jsx)(u.AvField,{name:"email",onBlur:function(){I(!0)},placeholder:"Elektron pochta manzili *",type:"text"}),Object(n.jsx)("img",{src:"/img/icon/birdCircle.png",alt:"2",className:A?"bird-circle ":"d-none"})]}),Object(n.jsx)("div",{className:"half-region",children:Object(n.jsxs)("div",{className:"row",children:[Object(n.jsx)("div",{className:"col-md-6",children:Object(n.jsxs)(u.AvField,{name:"region",type:"select",placeholder:"Tuman *",children:[Object(n.jsx)("option",{}),Object(n.jsx)("option",{children:"Toshkent"}),Object(n.jsx)("option",{children:"Jizzax"}),Object(n.jsx)("option",{children:"Farg\u2019ona"}),Object(n.jsx)("option",{children:"Qashqadaryo"}),Object(n.jsx)("option",{children:"Surxondaryo"})]})}),Object(n.jsx)("div",{className:"col-md-6",children:Object(n.jsxs)(u.AvField,{name:"district",type:"select",placeholder:"Viloyat *",children:[Object(n.jsx)("option",{}),Object(n.jsx)("option",{children:"Toshkent"}),Object(n.jsx)("option",{children:"Jizzax"}),Object(n.jsx)("option",{children:"Farg\u2019ona"}),Object(n.jsx)("option",{children:"Qashqadaryo"}),Object(n.jsx)("option",{children:"Surxondaryo"})]})}),Object(n.jsx)("div",{className:"col-md-12",children:Object(n.jsxs)(u.AvField,{name:"workPlaceId",type:"select",placeholder:"Ish joyi *",children:[Object(n.jsx)("option",{}),Object(n.jsx)("option",{children:"Jizzax Politexnika instituti"}),Object(n.jsx)("option",{children:"Jizzax Politexnika instituti"}),Object(n.jsx)("option",{children:"Jizzax Politexnika instituti"}),Object(n.jsx)("option",{children:"Jizzax Politexnika instituti"}),Object(n.jsx)("option",{children:"Jizzax Politexnika instituti"})]})})]})}),Object(n.jsx)("button",{onClick:function(){},className:"next-btn",children:"Keyingi"})]})})]})}),Object(n.jsx)(f.a,{isOpen:e.regstrModalNext,className:"regstr-modal",children:Object(n.jsxs)("div",{className:"reg-form-next",children:[Object(n.jsx)("div",{className:"close-btn",children:Object(n.jsx)("button",{onClick:function(){e.updateState({regstrModalNext:!e.regstrModalNext}),e.updateState({regstrModal:!1})},children:Object(n.jsx)("img",{src:"/img/icon/close.png"})})}),Object(n.jsx)("h2",{children:"Ro\u2019yxatdan o\u2019tish"}),Object(n.jsxs)("div",{className:"top-line-group",children:[Object(n.jsx)("div",{className:"line-next",children:Object(n.jsx)("img",{src:"/img/icon/bird.png",alt:""})}),Object(n.jsx)("div",{className:"min-line-one"}),Object(n.jsx)("span",{className:"title-one",children:"Identifikatsiya"}),Object(n.jsx)("div",{className:"center-line-two"}),Object(n.jsx)("div",{className:"line-next-two",children:Object(n.jsx)("span",{children:"2"})}),Object(n.jsx)("div",{className:"min-line-one"}),Object(n.jsx)("span",{className:"title-two",children:"Tasdiqlash"})]}),Object(n.jsx)("div",{children:Object(n.jsxs)(u.AvForm,{className:"form-group-val",onValidSubmit:function(e,s){},children:[Object(n.jsx)(u.AvField,{name:"teat",placeholder:"Login *",type:"text"}),Object(n.jsx)("div",{className:"half-region",children:Object(n.jsxs)("div",{className:"row",children:[Object(n.jsxs)("div",{className:"col-md-6",children:[Object(n.jsx)(u.AvField,{name:"teat",placeholder:"Parol kiriting *",type:a?"text":"password"}),Object(n.jsx)("button",{onClick:function(){l(!a)},children:a?Object(n.jsx)("img",{src:"/img/icon/Pass.png",alt:""}):Object(n.jsx)("img",{src:"/img/icon/showPass.png",alt:""})})]}),Object(n.jsxs)("div",{className:"col-md-6",children:[Object(n.jsx)(u.AvField,{name:"teat",placeholder:"Parol qayta kiriting *",type:d?"text":"password"}),Object(n.jsx)("button",{onClick:function(){o(!d)},children:d?Object(n.jsx)("img",{src:"/img/icon/Pass.png",alt:""}):Object(n.jsx)("img",{src:"/img/icon/showPass.png",alt:""})})]}),Object(n.jsxs)("div",{className:"col-md-12",children:[Object(n.jsx)("p",{children:"Diqqat!!! Ushbu raqamga kod sms tarzida yuboriladi. Shu sababli hozirda foydalanayotgan raqamingizni kiriting."}),Object(n.jsx)("img",{src:"/img/icon",alt:""}),Object(n.jsx)(u.AvField,{name:"teat",onFocus:function(e){document.getElementById("numberInput").value="+ 998",document.getElementById("numberInput").addEventListener("input",(function(e){var s=e.target.value.replace(/\D/g,"").match(/(\d{0,3})(\d{0,2})(\d{0,3})(\d{0,2})(\d{0,2})/);e.target.value="+ "+s[1]+" "+s[2]+" "+s[3]+" "+s[4]+" "+s[5]}))},id:"numberInput",placeholder:"Telefon raqami *",type:"text"})]}),Object(n.jsx)("div",{className:"col-md-8",children:Object(n.jsx)(u.AvField,{name:"teat",placeholder:"Kodni kiriting *",type:"text"})}),Object(n.jsx)("div",{className:"col-md-4",children:Object(n.jsx)("button",{children:"Kodni olish"})})]})}),Object(n.jsx)("button",{className:"next-btn",children:"Keyingi"})]})})]})})]})})),z=Object(r.b)((function(e){return{regstrModal:e.login.regstrModal,regstrModalNext:e.login.regstrModalNext,loginModal:e.login.loginModal,loginModalForgetPass:e.login.loginModalForgetPass}}),{updateState:p,LoginUser:v})((function(e){return Object(n.jsx)("div",{className:"navbar",children:Object(n.jsx)("div",{className:"container",children:Object(n.jsxs)("div",{className:"row",children:[Object(n.jsxs)("div",{className:"col-md-8",children:[Object(n.jsx)("a",{href:"#",children:Object(n.jsx)("img",{src:"/img/icon/home.png",alt:""})}),Object(n.jsx)("a",{href:"#",className:"navbar-menu",children:"Testlar"}),Object(n.jsx)("a",{href:"#",className:"navbar-menu",children:"Sertifikatlar"}),Object(n.jsx)("a",{href:"#",className:"navbar-menu",children:"Bog\u2019lanish"}),Object(n.jsx)("a",{href:"#",className:"navbar-menu",children:"Biz haqimizda"})]}),Object(n.jsxs)("div",{className:"col-md-4",children:[Object(n.jsx)("a",{href:"#",className:"lang-drp",children:"O'zbek"}),localStorage.getItem(m)?"":Object(n.jsxs)(n.Fragment,{children:[Object(n.jsx)("button",{onClick:function(){e.updateState({loginModal:!e.loginModal})},className:"enter-btn",children:"Kirish"}),Object(n.jsx)("button",{onClick:function(){e.updateState({regstrModal:!e.regstrModal})},className:"regstration",children:"Ro\u2019yxatdan o\u2019tish"})]})]}),Object(n.jsx)(k,{}),Object(n.jsx)(y,{history:e.history})]})})})})),w=function(){return Object(n.jsx)("div",{className:"home-banner",children:Object(n.jsx)("div",{className:"container",children:Object(n.jsxs)("div",{className:"row",children:[Object(n.jsxs)("div",{className:"col-md-6",children:[Object(n.jsxs)("h1",{children:["Xorijiy tillarni ",Object(n.jsx)("br",{}),"bilish darajasini baholash ",Object(n.jsx)("br",{}),"milliy tizimi"]}),Object(n.jsxs)("p",{children:["Istalgan vaqtda, istalgan joyda onlayn testdan o'ting ",Object(n.jsx)("br",{}),"va shaxsiylashtirilgan ForLang Certificate \u2122 ni oling"]}),Object(n.jsx)("a",{href:"#!",children:"Testni boshlash"})]}),Object(n.jsx)("div",{className:"col-md-6",children:Object(n.jsx)("img",{src:"/img/HomeGirl.png",alt:"2"})})]})})})},M=function(){return Object(n.jsx)("div",{className:"home-video-pair",children:Object(n.jsx)("div",{className:"container",children:Object(n.jsxs)("div",{className:"row",children:[Object(n.jsx)("div",{className:"col-md-5",children:Object(n.jsxs)("div",{className:"box-com",children:[Object(n.jsx)("div",{className:"player-bg"}),Object(n.jsx)("img",{src:"/img/vd.png",alt:""}),Object(n.jsx)("img",{src:"/img/icon/play.png",className:"play-btn",alt:""})]})}),Object(n.jsxs)("div",{className:"col-md-7",children:[Object(n.jsxs)("h2",{className:"min-title",children:["Horijiy tillardan ",Object(n.jsx)("br",{}),"sertifikatlashtirilgan onlayn test "]}),Object(n.jsx)("p",{children:"Bu tizim - oliy o'quv yurtlari va ish beruvchilarga hamda o\u2019qituvchilarga horijiy til darajasini va nomzodlar guruhlarini tekshirishga yordam beradigan tez va qulay onlayn test. U  ishonchli, tezkor, arzon va sertifikatlashtirilgan."}),Object(n.jsxs)("a",{href:"#!",children:["Batafsil ",Object(n.jsx)("img",{src:"/img/icon/rgihtArrow.png",alt:""})]})]})]})})})},S=function(){return Object(n.jsx)("div",{className:"home-rec",children:Object(n.jsxs)("div",{className:"container",children:[Object(n.jsx)("h2",{className:"min-title text-center",children:"Talab bo'yicha va  istalgan joyda"}),Object(n.jsxs)("div",{className:"row",children:[Object(n.jsx)("div",{className:"col-md-4",children:Object(n.jsxs)("div",{className:"box-child",children:[Object(n.jsx)("img",{src:"/img/laptop.png",alt:""}),Object(n.jsx)("h3",{children:"Qulay"}),Object(n.jsx)("p",{children:"Testni istalgan joyda xohlagan vaqtda onlayn o'tkazing test markaziga borish yoki uchrashuvga hojat yo'q"})]})}),Object(n.jsx)("div",{className:"col-md-4",children:Object(n.jsxs)("div",{className:"box-child",children:[Object(n.jsx)("img",{src:"/img/fastTime.png",alt:""}),Object(n.jsx)("h3",{children:"Tezkor"}),Object(n.jsx)("p",{children:"Sinov tugagandan so'ng 24 soat ichida o'z natijalaringizni olingva uni darhol hamma bilan baham ko'ring"})]})}),Object(n.jsx)("div",{className:"col-md-4",children:Object(n.jsxs)("div",{className:"box-child",children:[Object(n.jsx)("img",{src:"/img/decrease.png",alt:""}),Object(n.jsx)("h3",{children:"Arzon"}),Object(n.jsxs)("p",{children:["O'zingizning sertificatingizni atigi",Object(n.jsx)("b",{children:" 49 dollar"}),"ga oling, boshqa sertifikatlashtirish testlarining aksariyati ",Object(n.jsx)("b",{children:"200 dollar"}),"dan oshadi"]})]})})]})]})})},q=function(){return Object(n.jsx)("div",{className:"home-tests-pair",children:Object(n.jsxs)("div",{className:"container",children:[Object(n.jsx)("h2",{className:"min-title text-center",children:"Bizning testlar"}),Object(n.jsxs)("div",{className:"row",children:[Object(n.jsx)("div",{className:"col-md-4",children:Object(n.jsxs)("div",{className:"box-tests",children:[Object(n.jsxs)("div",{className:"box-tests-header",children:[Object(n.jsx)("div",{className:"left-img",children:Object(n.jsx)("img",{src:"/img/icon/fullTest.png",alt:""})}),Object(n.jsxs)("div",{className:"right-content",children:[Object(n.jsxs)("h4",{children:["Full Test",Object(n.jsx)("span",{children:"Sertificate"})]}),Object(n.jsx)("h5",{children:"Exam"})]})]}),Object(n.jsxs)("div",{className:"box-tests-body",children:[Object(n.jsx)("p",{children:"Reading, Listening, Writing and Speaking sections"}),Object(n.jsxs)("div",{className:"box-tests-bootom",children:[Object(n.jsxs)("div",{children:[Object(n.jsx)("img",{src:"/img/icon/Vector.png",alt:""}),Object(n.jsx)("span",{children:"30 daqiqa"})]}),Object(n.jsxs)("div",{children:[Object(n.jsx)("img",{src:"/img/icon/check.png",alt:""}),Object(n.jsx)("span",{children:"40 ta test"})]})]})]}),Object(n.jsxs)("div",{className:"price",children:[Object(n.jsx)("h3",{children:"$52"}),Object(n.jsxs)("a",{href:"#",children:["Boshlash ",Object(n.jsx)("img",{src:"/img/icon/rightArrow.png",alt:"2"})]})]})]})}),Object(n.jsx)("div",{className:"col-md-4",children:Object(n.jsxs)("div",{className:"box-tests",children:[Object(n.jsxs)("div",{className:"box-tests-header",children:[Object(n.jsx)("div",{className:"left-img",children:Object(n.jsx)("img",{src:"/img/icon/tit.png",alt:""})}),Object(n.jsxs)("div",{className:"right-content",children:[Object(n.jsx)("h4",{children:"Reading section"}),Object(n.jsx)("h5",{children:"Test"})]})]}),Object(n.jsxs)("div",{className:"box-tests-body",children:[Object(n.jsx)("p",{children:"Mos keluvchi, ko'p tanlovli, to'g'ri/noto'g'ri, tugallangan test"}),Object(n.jsxs)("div",{className:"box-tests-bootom",children:[Object(n.jsxs)("div",{children:[Object(n.jsx)("img",{src:"/img/icon/Vector.png",alt:""}),Object(n.jsx)("span",{children:"30 daqiqa"})]}),Object(n.jsxs)("div",{children:[Object(n.jsx)("img",{src:"/img/icon/check.png",alt:""}),Object(n.jsx)("span",{children:"40 ta test"})]})]})]}),Object(n.jsxs)("div",{className:"price",children:[Object(n.jsx)("h3",{children:"$15"}),Object(n.jsxs)("a",{href:"#",children:["Boshlash ",Object(n.jsx)("img",{src:"/img/icon/rightArrow.png",alt:"2"})]})]})]})}),Object(n.jsx)("div",{className:"col-md-4",children:Object(n.jsxs)("div",{className:"box-tests",children:[Object(n.jsxs)("div",{className:"box-tests-header",children:[Object(n.jsx)("div",{className:"left-img",children:Object(n.jsx)("img",{src:"/img/icon/commit.png",alt:""})}),Object(n.jsxs)("div",{className:"right-content",children:[Object(n.jsx)("h4",{children:"Listening section"}),Object(n.jsx)("h5",{children:"Test"})]})]}),Object(n.jsxs)("div",{className:"box-tests-body",children:[Object(n.jsx)("p",{children:"Akademik suhbat va monolog Kundalik suhbat va monolog"}),Object(n.jsxs)("div",{className:"box-tests-bootom",children:[Object(n.jsxs)("div",{children:[Object(n.jsx)("img",{src:"/img/icon/Vector.png",alt:""}),Object(n.jsx)("span",{children:"30 daqiqa"})]}),Object(n.jsxs)("div",{children:[Object(n.jsx)("img",{src:"/img/icon/check.png",alt:""}),Object(n.jsx)("span",{children:"40 ta test"})]})]})]}),Object(n.jsxs)("div",{className:"price",children:[Object(n.jsx)("h3",{children:"$15"}),Object(n.jsxs)("a",{href:"#",children:["Boshlash ",Object(n.jsx)("img",{src:"/img/icon/rightArrow.png",alt:"2"})]})]})]})}),Object(n.jsx)("div",{className:"col-md-4",children:Object(n.jsxs)("div",{className:"box-tests",children:[Object(n.jsxs)("div",{className:"box-tests-header",children:[Object(n.jsx)("div",{className:"left-img",children:Object(n.jsx)("img",{src:"/img/icon/pen.png",alt:""})}),Object(n.jsxs)("div",{className:"right-content",children:[Object(n.jsx)("h4",{children:"Writing section"}),Object(n.jsx)("h5",{children:"Test"})]})]}),Object(n.jsxs)("div",{className:"box-tests-body",children:[Object(n.jsxs)("p",{children:["Ma'lumotlarni talqin qilish ",Object(n.jsx)("br",{}),"va insho"]}),Object(n.jsxs)("div",{className:"box-tests-bootom",children:[Object(n.jsxs)("div",{children:[Object(n.jsx)("img",{src:"/img/icon/Vector.png",alt:""}),Object(n.jsx)("span",{children:"30 daqiqa"})]}),Object(n.jsxs)("div",{children:[Object(n.jsx)("img",{src:"/img/icon/check.png",alt:""}),Object(n.jsx)("span",{children:"40 ta test"})]})]})]}),Object(n.jsxs)("div",{className:"price",children:[Object(n.jsx)("h3",{children:"$15"}),Object(n.jsxs)("a",{href:"#",children:["Boshlash ",Object(n.jsx)("img",{src:"/img/icon/rightArrow.png",alt:"2"})]})]})]})}),Object(n.jsx)("div",{className:"col-md-4",children:Object(n.jsxs)("div",{className:"box-tests",children:[Object(n.jsxs)("div",{className:"box-tests-header",children:[Object(n.jsx)("div",{className:"left-img",children:Object(n.jsx)("img",{src:"/img/icon/man.png",alt:""})}),Object(n.jsxs)("div",{className:"right-content",children:[Object(n.jsx)("h4",{children:"Speaking section"}),Object(n.jsx)("h5",{children:"Test, audio"})]})]}),Object(n.jsxs)("div",{className:"box-tests-body",children:[Object(n.jsx)("p",{children:"Tanishtirish, tasvirlash hamda muhokama qilish"}),Object(n.jsxs)("div",{className:"box-tests-bootom",children:[Object(n.jsxs)("div",{children:[Object(n.jsx)("img",{src:"/img/icon/Vector.png",alt:""}),Object(n.jsx)("span",{children:"30 daqiqa"})]}),Object(n.jsxs)("div",{children:[Object(n.jsx)("img",{src:"/img/icon/check.png",alt:""}),Object(n.jsx)("span",{children:"40 ta test"})]})]})]}),Object(n.jsxs)("div",{className:"price",children:[Object(n.jsx)("h3",{children:"$18"}),Object(n.jsxs)("a",{href:"#",children:["Boshlash ",Object(n.jsx)("img",{src:"/img/icon/rightArrow.png",alt:"2"})]})]})]})})]})]})})},F=function(){return Object(n.jsx)("div",{className:"home-sertificate",children:Object(n.jsx)("div",{className:"container",children:Object(n.jsx)("div",{className:"row",children:Object(n.jsxs)("div",{className:"col-md-6",children:[Object(n.jsx)("h2",{children:"Bizning Sertifikat"}),Object(n.jsxs)("p",{children:["Horijiy tillardan test topshiring ",Object(n.jsx)("br",{}),"va  qisqa muddatda o\u2019z natijangizni bilib oling. ",Object(n.jsx)("br",{}),"Horijiy tillarni bilish darajangizdagi sertifikatga ega bo\u2019ling."]}),Object(n.jsx)("a",{href:"#!",children:"Sertifikatni olish"})]})})})})},T=function(){return Object(n.jsx)("div",{className:"footer",children:Object(n.jsx)("div",{className:"container",children:Object(n.jsxs)("div",{className:"row",children:[Object(n.jsxs)("div",{className:"col-md-6",children:[Object(n.jsxs)("div",{className:"footer-logo",children:[Object(n.jsx)("img",{src:"/img/icon/gerb.png",alt:""}),Object(n.jsxs)("h1",{children:["xorijiy tillarni o'rganishni ",Object(n.jsx)("br",{}),"ommalashtirish Agentligi"]})]}),Object(n.jsxs)("div",{className:"geo",children:[Object(n.jsx)("img",{src:"/img/icon/geo.png",alt:"2"}),Object(n.jsxs)("p",{children:["Manzil: Toshkent shahri, Mirzo Ulug\u2019bek tumani ",Object(n.jsx)("br",{}),"Buyuk Ipak yuli metro, 70/37 - uy, 100100"]})]})]}),Object(n.jsx)("div",{className:"col-md-6",children:Object(n.jsxs)("div",{className:"row",children:[Object(n.jsxs)("div",{className:"col-md-6",children:[Object(n.jsx)("a",{href:"#!",children:"Asosiy"}),Object(n.jsx)("a",{href:"#!",children:"Testlar"}),Object(n.jsx)("a",{href:"#!",children:"Sertifikatlar"}),Object(n.jsx)("a",{href:"#!",children:"Biz haqimizda"})]}),Object(n.jsxs)("div",{className:"col-md-6",children:[Object(n.jsx)("a",{href:"#!",children:"Biz bilan aloqa"}),Object(n.jsxs)("a",{href:"#!",children:[Object(n.jsx)("img",{src:"/img/icon/phone.png",alt:""}),"998 91 191 99 99"]}),Object(n.jsxs)("a",{href:"#!",children:[Object(n.jsx)("img",{src:"/img/icon/arr.png",alt:""}),"info@foreignlang.uz"]})]})]})})]})})})},A=i(37),I=i(191),P=i.n(I);function B(){function e(e){var s=e.onClick;return Object(n.jsx)("div",{className:"slide-rarr",onClick:s,children:Object(n.jsx)("img",{src:"/img/icon/rarr.png",alt:""})})}function s(e){var s=e.onClick;return Object(n.jsx)("div",{className:"slide-larr",onClick:s,children:Object(n.jsx)("img",{src:"/img/icon/larr.png",alt:""})})}var i={dots:!0,infinite:!1,speed:500,slidesToShow:4,slidesToScroll:1,initialSlide:0,nextArrow:Object(n.jsx)(e,{}),prevArrow:Object(n.jsx)(s,{}),responsive:[{breakpoint:1024,settings:{slidesToShow:3,slidesToScroll:1,infinite:!0,dots:!0}},{breakpoint:600,settings:{slidesToShow:2,slidesToScroll:1,initialSlide:2}},{breakpoint:480,settings:{slidesToShow:1,slidesToScroll:1}}]};return Object(n.jsxs)("div",{className:"home-partners",children:[Object(n.jsx)("h2",{className:"min-title text-center",children:"Bizning hamkorlar"}),Object(n.jsxs)(P.a,Object(A.a)(Object(A.a)({},i),{},{className:"py-5",children:[Object(n.jsx)("div",{className:"slideItem",children:Object(n.jsxs)("div",{className:"slide-box",children:[Object(n.jsx)("img",{src:"/img/s1.png",alt:""}),Object(n.jsx)("h5",{children:"O\u2018zbekiston Respublikasi Prezidentining rasmiy veb sayti"})]})}),Object(n.jsx)("div",{className:"slideItem",children:Object(n.jsxs)("div",{className:"slide-box",children:[Object(n.jsx)("img",{src:"/img/s2.png",alt:""}),Object(n.jsx)("h5",{children:"Davlat interaktiv xizmatlari yagona portali"})]})}),Object(n.jsx)("div",{className:"slideItem",children:Object(n.jsxs)("div",{className:"slide-box",children:[Object(n.jsx)("img",{src:"/img/s3.png",alt:""}),Object(n.jsx)("h5",{children:"O\u2018zbekiston Respublikasi ochik ma'lumotlari portali"})]})}),Object(n.jsx)("div",{className:"slideItem",children:Object(n.jsxs)("div",{className:"slide-box",children:[Object(n.jsx)("img",{src:"/img/s4.png",alt:""}),Object(n.jsx)("h5",{children:"O\u2018zbekiston Respublikasi Maktabgacha Ta'lim Vazirligi"})]})}),Object(n.jsx)("div",{className:"slideItem",children:Object(n.jsxs)("div",{className:"slide-box",children:[Object(n.jsx)("img",{src:"/img/s1.png",alt:""}),Object(n.jsx)("h5",{children:"O\u2018zbekiston Respublikasi Prezidentining rasmiy veb sayti"})]})}),Object(n.jsx)("div",{className:"slideItem",children:Object(n.jsxs)("div",{className:"slide-box",children:[Object(n.jsx)("img",{src:"/img/s2.png",alt:""}),Object(n.jsx)("h5",{children:"Davlat interaktiv xizmatlari yagona portali"})]})}),Object(n.jsx)("div",{className:"slideItem",children:Object(n.jsxs)("div",{className:"slide-box",children:[Object(n.jsx)("img",{src:"/img/s3.png",alt:""}),Object(n.jsx)("h5",{children:"O\u2018zbekiston Respublikasi ochik ma'lumotlari portali"})]})}),Object(n.jsx)("div",{className:"slideItem",children:Object(n.jsxs)("div",{className:"slide-box",children:[Object(n.jsx)("img",{src:"/img/s4.png",alt:""}),Object(n.jsx)("h5",{children:"O\u2018zbekiston Respublikasi Maktabgacha Ta'lim Vazirligi"})]})})]}))]})}var C=function(e){return Object(n.jsxs)("div",{children:[Object(n.jsx)(l,{}),Object(n.jsx)(z,{history:e.history}),Object(n.jsx)(w,{}),Object(n.jsx)(M,{}),Object(n.jsx)(S,{}),Object(n.jsx)(q,{}),Object(n.jsx)(F,{}),Object(n.jsx)(B,{}),Object(n.jsx)(T,{})]})},E=i(158),R=function(e){return Object(n.jsxs)("div",{className:"edit-profile",children:[Object(n.jsx)(z,{history:e.history}),Object(n.jsx)("div",{className:"container",children:Object(n.jsxs)("div",{className:"row",children:[Object(n.jsx)("div",{className:"col-md-3",children:Object(n.jsxs)("div",{className:"edit-profile-left",children:[Object(n.jsx)("h4",{children:"Mening profilim"}),Object(n.jsxs)("div",{className:"edit-profile-left-child",children:[Object(n.jsx)("div",{className:"edit-profile-left-child-in"}),Object(n.jsx)(E.a,{children:"Shaxsiy ma\u2019lumotlar"})]}),Object(n.jsxs)("div",{className:"edit-profile-left-child",children:[Object(n.jsx)("div",{className:"edit-profile-left-child-in"}),Object(n.jsx)(E.a,{children:"Testlar"})]}),Object(n.jsxs)("div",{className:"edit-profile-left-child",children:[Object(n.jsx)("div",{className:"edit-profile-left-child-in"}),Object(n.jsx)(E.a,{children:"To\u2019lovlar"})]}),Object(n.jsxs)("div",{className:"edit-profile-left-child",children:[Object(n.jsx)("div",{className:"edit-profile-left-child-in"}),Object(n.jsx)(E.a,{children:" ma\u2019lumotlar"})]}),Object(n.jsx)("h4",{children:"Sozlamalar"}),Object(n.jsx)("h4",{children:"Chiqish"})]})}),Object(n.jsxs)("div",{className:"col-md-9",children:[Object(n.jsxs)("div",{className:"edit-profile-right",children:[Object(n.jsxs)("div",{className:"edit-right-header ",children:[Object(n.jsx)("h4",{children:"Shaxsiy ma\u2019lumotlar"}),Object(n.jsx)("img",{src:"/img/icon/qalam.png",alt:""})]}),Object(n.jsx)("div",{className:"line"}),Object(n.jsxs)("div",{className:"row",children:[Object(n.jsx)("div",{className:"col-md-8",children:Object(n.jsxs)(u.AvForm,{children:[Object(n.jsxs)("div",{className:"form-group",children:[Object(n.jsx)(u.AvInput,{name:"name",required:!0}),Object(n.jsx)("label",{htmlFor:"name",children:"F.I.O"})]}),Object(n.jsxs)("div",{className:"form-group",children:[Object(n.jsx)(u.AvInput,{name:"pochta",required:!0}),Object(n.jsx)("label",{htmlFor:"pochta",children:"Elektron pochta manzili"})]}),Object(n.jsxs)("div",{className:"form-group",children:[Object(n.jsx)(u.AvInput,{name:"passport",required:!0}),Object(n.jsx)("label",{htmlFor:"passport",children:"Passport seriya va raqami"})]}),Object(n.jsxs)("div",{className:"form-group",children:[Object(n.jsx)(u.AvInput,{name:"telephony",type:"number",required:!0}),Object(n.jsx)("label",{htmlFor:"telephony",children:"Telefon raqami"})]})]})}),Object(n.jsxs)("div",{className:"col-md-4",children:[Object(n.jsx)("img",{src:"img/icon/Editimage.png",alt:""}),Object(n.jsx)(u.AvForm,{children:Object(n.jsxs)("div",{className:"form-group",children:[Object(n.jsx)(u.AvInput,{name:"login",required:!0}),Object(n.jsx)("label",{htmlFor:"login",children:"login"})]})})]})]})]}),Object(n.jsxs)("div",{className:"edit-profile-right-end",children:[Object(n.jsxs)("div",{className:"edit-right-header",children:[Object(n.jsx)("h4",{children:"Manzil"}),Object(n.jsx)("img",{src:"/img/icon/qalam.png",alt:""})]}),Object(n.jsx)("div",{className:"line"}),Object(n.jsxs)("div",{className:"row",children:[Object(n.jsx)("div",{className:"col-md-6",children:Object(n.jsx)(u.AvForm,{children:Object(n.jsxs)("div",{className:"form-group",children:[Object(n.jsx)(u.AvInput,{name:"district",required:!0}),Object(n.jsx)("label",{htmlFor:"district",children:"tuman"})]})})}),Object(n.jsx)("div",{className:"col-md-6",children:Object(n.jsx)(u.AvForm,{children:Object(n.jsxs)("div",{className:"form-group",children:[Object(n.jsx)(u.AvInput,{name:"region",required:!0}),Object(n.jsx)("label",{htmlFor:"region",children:"viloyat"})]})})}),Object(n.jsx)("div",{className:"col-md-12",children:Object(n.jsxs)(u.AvForm,{children:[Object(n.jsxs)("div",{className:"form-group",children:[Object(n.jsx)(u.AvInput,{name:"place",required:!0}),Object(n.jsx)("label",{htmlFor:"place",children:"Ish joyi"})]}),"                                    "]})})]})]})]})]})})]})},L=i(64),D=i(14),V=(i(423),function(){return Object(n.jsx)("div",{})}),_=(i(424),Object(r.b)(null,null)((function(){return Object(n.jsx)("div",{className:"admin-work content",children:Object(n.jsx)("div",{className:"d-flex align-items-center justify-content-end",children:Object(n.jsx)("button",{type:"button",className:"btn btn-success",children:"Viloyat yaratish"})})})}))),U=function(){return Object(n.jsx)("div",{children:"dw"})},J=function(){return Object(n.jsx)("div",{children:"404"})},K=function(e){return Object(n.jsxs)("div",{className:"admin-layout",children:[Object(n.jsxs)("div",{className:"admin-layout-left",children:[Object(n.jsx)("h3",{className:"admin-layout-left-text text-center mb-0",children:"Dashboard"}),Object(n.jsxs)("ul",{className:"nav flex-column",children:[Object(n.jsx)("li",{className:"nav-item",children:Object(n.jsxs)(L.b,{to:"/admin/work-places",className:"nav-link ".concat(e.location.pathname.includes("/admin/work-places")?"active":""),children:[Object(n.jsx)("span",{className:"icon icon-stack"})," Ish joylari"]})}),Object(n.jsx)("li",{className:"nav-item",children:Object(n.jsxs)(L.b,{to:"/admin/users",className:"nav-link ".concat(e.location.pathname.includes("/admin/users")?"active":""),children:[Object(n.jsx)("span",{className:"icon icon-users"})," Foydalanuvchilar"]})})]})]}),Object(n.jsxs)("div",{className:"admin-layout-right",children:[Object(n.jsxs)("div",{className:"admin-layout-right-navbar d-flex align-items-center justify-content-between",children:[Object(n.jsx)("div",{}),Object(n.jsxs)("div",{className:"d-flex align-items-center",children:[Object(n.jsx)("span",{className:"icon icon-search"}),Object(n.jsx)("div",{className:"notification",children:Object(n.jsx)("span",{className:"icon icon-notification"})}),Object(n.jsx)("img",{src:"/img/user.png",alt:"user.png"})]})]}),Object(n.jsxs)(D.c,{children:[Object(n.jsx)(D.a,{path:"/admin/work-places",component:_}),Object(n.jsx)(D.a,{path:"/admin/users",component:U}),Object(n.jsx)(D.a,{component:J})]})]})]})};var X=function(){return Object(n.jsxs)(L.a,{children:[Object(n.jsx)("div",{children:Object(n.jsxs)(D.c,{children:[Object(n.jsx)(D.a,{path:"/",exact:!0,component:C}),Object(n.jsx)(D.a,{path:"/edit",exact:!0,component:R}),Object(n.jsx)(D.a,{path:"/tests",exact:!0,component:V}),Object(n.jsx)(D.a,{path:"/Edit",exact:!0,component:R}),Object(n.jsx)(D.a,{path:"/admin",component:K})]})}),Object(n.jsx)(g.a,{})]})},$=(i(426),i(427),i(193)),H=i(53),Q={isLoading:!1,regstrModal:!1,regstrModalNext:!1,loginModal:!1,loginModalForgetPass:!1,region:[],firstDataForRegstration:{}},W="WORK_UPDATE_STATE",G={regions:[],districts:[]},Y=Object(H.b)({login:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:Q,s=arguments.length>1?arguments[1]:void 0;switch(s.type){case b:return Object(A.a)(Object(A.a)({},e),s.payload);default:return e}},work:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:G,s=arguments.length>1?arguments[1]:void 0;switch(s.type){case W:return Object(A.a)(Object(A.a)({},e),s.payload);default:return e}}}),Z=Object(H.d)(Y,Object(H.c)(Object(H.a)($.a),window.__REDUX_DEVTOOLS_EXTENSION__&&window.__REDUX_DEVTOOLS_EXTENSION__()));a.a.render(Object(n.jsx)(r.a,{store:Z,children:Object(n.jsx)(X,{})}),document.getElementById("root"))}},[[428,1,2]]]);
//# sourceMappingURL=main.ecb5587b.chunk.js.map