<template>
    <div id="wrap">
        <div class="container">
            <div class="row">
                    <h1 id="logo">Logo</h1>
                <div class="col-md-12 ">
                    <h1 v-if="$store.state.userInfo.userId" style="color:#fff; margin-bottom:50px;">
                        ID값이 {{$store.state.userInfo.userId}}인 유저접속</h1>
                    <div v-else>
                    <router-link  to="/login" class="btn btn-primary" >로그인</router-link> <br/> 
                    <!-- <router-link to="" class="btn btn-primary">임의버튼</router-link><br/> -->
                    <router-link  to="/join"  class="btn btn-outline-primary">아이디가 없으신가요? 회원가입</router-link>
                    </div>
                    <router-link  to="/mypage" v-if="this.$store.state.userInfo.logintf"  class="btn btn-outline-primary">마이페이지</router-link>
                </div>
            </div>
        </div>
    </div>
</template>





<style scoped>
#wrap{position:relative;height:100%; min-height:100%; background:black; }
.container{height:100%;}
.row{padding-top:20%;}
.row h1{margin:0 auto;}
#logo{color:#fff;  margin-bottom:10%;  }
.row div {text-align: center; }
.row div a {margin-bottom:15px; }
</style>
