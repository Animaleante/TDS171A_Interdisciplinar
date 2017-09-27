@extends('layouts.master')

@section('content')
    <main class="main" role="main">
        <div class="wrap clearfix">

            <nav class="breadcrumbs">
                <ul>
                    <li><a href="index.html" title="Home">Home</a></li>
                    <li>Recipes</li>
                </ul>
            </nav>

            <div class="row">
                <header class="s-title">
                    <h1>Recipes</h1>
                </header>
                
                <aside class="above-sidebar full-width">
                    <ul class="boxed">
                        <li class="light"><a href="recipes.html" title="Appetizers"><i class="icon icon-themeenergy_pasta"></i> <span>Apetizers</span></a></li>
                        <li class="medium"><a href="recipes.html" title="Cocktails"><i class="icon icon-themeenergy_margarita2"></i> <span>Cocktails</span></a></li>
                        <li class="dark"><a href="recipes.html" title="Deserts"><i class="icon icon-themeenergy_cupcake"></i> <span>Deserts</span></a></li>
                        
                        <li class="light"><a href="recipes.html" title="Cocktails"><i class="icon icon-themeenergy_eggs"></i> <span>Eggs</span></a></li>
                        <li class="medium"><a href="recipes.html" title="Equipment"><i class="icon icon-themeenergy_blender"></i> <span>Equipment</span></a></li>
                        <li class="dark"><a href="recipes.html" title="Events"><i class="icon icon-themeenergy_turkey"></i> <span>Events</span></a></li>
                    
                        <li class="light"><a href="recipes.html" title="Fish"><i class="icon icon-themeenergy_fish2"></i> <span>Fish</span></a></li>
                        <li class="medium"><a href="recipes.html" title="Ftness"><i class="icon icon-themeenergy_biceps"></i> <span>Fitness</span></a></li>
                        <li class="dark"><a href="recipes.html" title="Healthy"><i class="icon icon-themeenergy_apple2"></i> <span>Healthy</span></a></li>
                        
                        <li class="medium"><a href="recipes.html" title="Asian"><i class="icon icon-themeenergy_sushi"></i> <span>Asian</span></a></li>
                        <li class="dark"><a href="recipes.html" title="Mexican"><i class="icon icon-themeenergy_peper"></i> <span>Mexican</span></a></li>
                        <li class="light"><a href="recipes.html" title="Pizza"><i class="icon  icon-themeenergy_pizza-slice"></i> <span>Pizza</span></a></li>
                        
                        <li class="medium"><a href="recipes.html" title="Kids"><i class="icon icon-themeenergy_happy"></i> <span>Kids</span></a></li>
                        <li class="dark"><a href="recipes.html" title="Meat"><i class="icon icon-themeenergy_meat"></i> <span>Meat</span></a></li>
                        <li class="light"><a href="recipes.html" title="Snacks"><i class="icon icon-themeenergy_fried-potatoes"></i> <span>Snacks</span></a></li>
                        
                        <li class="medium"><a href="recipes.html" title="Salads"><i class="icon icon-themeenergy_eggplant"></i> <span>Salads</span></a></li>
                        <li class="dark"><a href="recipes.html" title="Storage"><i class="icon icon-themeenergy_soup2"></i> <span>Soups</span></a></li>
                        <li class="light"><a href="recipes.html" title="Vegetarian"><i class="icon icon-themeenergy_plant-symbol"></i> <span>Vegetarian</span></a></li>
                    </ul>
                </aside>
                
                <section class="content full-width">
                    <div class="entries row">
                        <div class="entry one-fourth">
                            <figure>
                                <img src="images/img6.jpg" alt="" />
                                <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                            </figure>
                            <div class="container">
                                <h2><a href="recipe.html">Thai fried rice with fruit and vegetables</a></h2> 
                                <div class="actions">
                                    <div>
                                        <div class="difficulty"><i class="ico i-medium"></i><a href="#">medium</a></div>
                                        <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                        <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="entry one-fourth">
                            <figure>
                                <img src="images/img5.jpg" alt="" />
                                <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                            </figure>
                            <div class="container">
                                <h2><a href="recipe.html">Spicy Morroccan prawns with cherry tomatoes</a></h2> 
                                <div class="actions">
                                    <div>
                                        <div class="difficulty"><i class="ico i-hard"></i><a href="#">hard</a></div>
                                        <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                        <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="entry one-fourth">
                            <figure>
                                <img src="images/img8.jpg" alt="" />
                                <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                            </figure>
                            <div class="container">
                                <h2><a href="recipe.html">Super easy blueberry cheesecake</a></h2> 
                                <div class="actions">
                                    <div>
                                        <div class="difficulty"><i class="ico i-easy"></i><a href="#">easy</a></div>
                                        <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                        <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="entry one-fourth">
                            <figure>
                                <img src="images/img7.jpg" alt="" />
                                <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                            </figure>
                            <div class="container">
                                <h2><a href="recipe.html">Refreshing banana split with a twist for adults</a></h2> 
                                <div class="actions">
                                    <div>
                                        <div class="difficulty"><i class="ico i-hard"></i><a href="#">hard</a></div>
                                        <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                        <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="entry one-fourth">
                            <figure>
                                <img src="images/img3.jpg" alt="" />
                                <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                            </figure>
                            <div class="container">
                                <h2><a href="recipe.html">Sushi mania: this is the best sushi you have ever tasted</a></h2> 
                                <div class="actions">
                                    <div>
                                        <div class="difficulty"><i class="ico i-hard"></i><a href="#">hard</a></div>
                                        <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                        <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="entry one-fourth">
                            <figure>
                                <img src="images/img4.jpg" alt="" />
                                <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                            </figure>
                            <div class="container">
                                <h2><a href="recipe.html">Princess puffs - an old classic at its best</a></h2> 
                                <div class="actions">
                                    <div>
                                        <div class="difficulty"><i class="ico i-hard"></i><a href="#">hard</a></div>
                                        <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                        <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="entry one-fourth">
                            <figure>
                                <img src="images/img13.jpg" alt="" />
                                <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                            </figure>
                            <div class="container">
                                <h2><a href="recipe.html">Tasty salmon apetizers with sour cream</a></h2> 
                                <div class="actions">
                                    <div>
                                        <div class="difficulty"><i class="ico i-easy"></i><a href="#">easy</a></div>
                                        <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                        <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="entry one-fourth">
                            <figure>
                                <img src="images/img14.jpg" alt="" />
                                <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                            </figure>
                            <div class="container">
                                <h2><a href="recipe.html">An incredible vegetarian hamburger</a></h2> 
                                <div class="actions">
                                    <div>
                                        <div class="difficulty"><i class="ico i-easy"></i><a href="#">easy</a></div>
                                        <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                        <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="entry one-fourth">
                            <figure>
                                <img src="images/img15.jpg" alt="" />
                                <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                            </figure>
                            <div class="container">
                                <h2><a href="recipe.html">Spaghetti carbonara with rustic bread</a></h2> 
                                <div class="actions">
                                    <div>
                                        <div class="difficulty"><i class="ico i-medium"></i><a href="#">medium</a></div>
                                        <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                        <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="entry one-fourth">
                            <figure>
                                <img src="images/img16.jpg" alt="" />
                                <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                            </figure>
                            <div class="container">
                                <h2><a href="recipe.html">Homemade cheesy spinach pizza with an egg on top</a></h2> 
                                <div class="actions">
                                    <div>
                                        <div class="difficulty"><i class="ico i-medium"></i><a href="#">medium</a></div>
                                        <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                        <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="entry one-fourth">
                            <figure>
                                <img src="images/img17.jpg" alt="" />
                                <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                            </figure>
                            <div class="container">
                                <h2><a href="recipe.html">Heavenly light and creamy vanilla tart</a></h2> 
                                <div class="actions">
                                    <div>
                                        <div class="difficulty"><i class="ico i-hard"></i><a href="#">hard</a></div>
                                        <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                        <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="entry one-fourth">
                            <figure>
                                <img src="images/img18.jpg" alt="" />
                                <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                            </figure>
                            <div class="container">
                                <h2><a href="recipe.html">Exquisite plum and cherry pie</a></h2> 
                                <div class="actions">
                                    <div>
                                        <div class="difficulty"><i class="ico i-medium"></i><a href="#">medium</a></div>
                                        <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                        <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="quicklinks">
                            <a href="#" class="button">More recipes</a>
                            <a href="javascript:void(0)" class="button scroll-to-top">Back to top</a>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </main>
@endsection