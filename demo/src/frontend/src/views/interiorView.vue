<template>
    <div>
        <body>

<div class="container">
  <p style="margin-left: 73%; font-size: 25px;" class="">product portpolio</p>
    <!--<h1 style="margin-left: 78%;">Product interior</h1>-->
    </div>
    <hr width="1350px">
<div style="margin-left: 20%;  margin-top: 50px;">   
<table cellpadding="75">
<tr>
<td>
 <!-- <strong p class="lead text-muted">Araucaria heterophylla</strong></p><br>-->
    <a href="#"> <img :src="require(`../assets/interior_img/${interior1}.jpg`)" alt="인테리어1" style="width: 400px;" > </a><br><br>
        <div class="card-body">
            <strong p class="card-text"> Araucaria heterophylla</strong>
            <div class="d-flex justify-content-between align-items-center">
              <!--<div class="btn-group">
              <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
            </div>-->
        </div>
      </div></td>
<td>
   <a href="#"> <img :src="require(`../assets/interior_img/${interior2}.png`)" alt="인테리어2" style="width: 400px;" > </a><br><br>
        <div class="card-body">
            <p><strong p class="card-text"> Olea europaea L.</strong></p>
            <div class="d-flex justify-content-between align-items-center">
        </div>
      </div></td>
</tr>    
</table>
</div> 



<table cellpadding="75">
<tr>
<td>
  <div class="container">
      <a href="#"> <img :src="require(`../assets/interior_img/${interior3}.png`)" alt="인테리어3" style="width: 400px;" > </a><br><br>
          <div class="card-body">
            <p><strong p class="card-text"> Myrtillocactus geometrizans</strong></p>
            <div class="d-flex justify-content-between align-items-center">
            </div>
          </div> </div> </td>

<td>
<div class="container">
      <a href="#"> <img :src="require(`../assets/interior_img/${interior4}.png`)" alt="인테리어2" style="width: 400px;" > </a><br><br>
          <div class="card-body">
            <p><strong p class="card-text"> Cereus jamacaru</strong></p>
            <div class="d-flex justify-content-between align-items-center">
            </div>
          </div> </div>
        </td>
        </tr>
</table>




 <!-- 페이징 -->
 <p id="paging">
  <button>1</button>
  <button>2</button>
  <button style="color:white; background-color:rgb(22, 160, 133)">3</button>
  <button>4</button>
</p>
</body>
    </div>
</template>

<script>
    export default {
        name: 'interior-view',
        data() {
            return {
                interior1: "qqq",
                interior2: "in1",
                interior3: "in2",
                interior4: "in3",
            }
        }
    }
</script>

<style scoped>
    img:hover {
        width:200px;
        transform:scale(1.05);
        transition: transform.10s;
        }

    @import "../css/main_customer.css";
</style>