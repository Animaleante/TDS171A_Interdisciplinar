@extends('layouts.master')

@section('content')
    <main class="main" role="main">
        <!--wrap-->
        <div class="wrap clearfix">
            <!--breadcrumbs-->
            <nav class="breadcrumbs">
                <ul>
                    <li><a href="index.html" title="Home">Home</a></li>
                    <li>Search for Recipes</li>
                </ul>
            </nav>
            <!--//breadcrumbs-->
            
            <!--row-->
            <div class="row">
                <header class="s-title">
                    <h1>Search for Recipes</h1>
                </header>
                
                <!--content-->
                <section class="content full-width">
                    <!--recipefinder-->
                    <div class="container recipefinder">
                        <div class="left">
                            <h3>Search by ingredients</h3>
                            <p>Click the ‘-’ to remove an ingredient, or click the ingredient itself to emphasize</p>
                            <div class="f-row">
                                <input type="text" placeholder="Add ingredients (one at a time)" />
                                <button class="add">+</button>
                            </div>
                            <div class="f-row">
                                <input type="text" value="garlic" />
                                <button class="remove">-</button>
                            </div>
                            <div class="f-row">
                                <input type="submit" value="Search" />
                            </div>
                        </div>
                        <div class="right">
                            <div class="ingredients">
                                <h3>Do you also have?</h3>
                                <a href="#" class="button gold">Olive oil</a><a href="#" class="button gold">Parsley</a><a href="#" class="button gold">Tomato</a><a href="#" class="button gold">Olive oil</a><a href="#" class="button gold">Parsley</a><a href="#" class="button gold">Tomato</a><a href="#" class="button gold">Parsley</a><a href="#" class="button gold">Tomato</a><a href="#" class="button gold">Olive oil</a><a href="#" class="button gold">Parsley</a><a href="#" class="button gold">Tomato</a>
                            </div>
                            
                            <h3>Or you might want to search directly</h3>
                            <div class="row">
                                <div class="search one-half">
                                    <input type="search" placeholder="Find recipe by name" />
                                    <input type="submit" value="Search" />
                                </div>
                                
                                <div class="one-half">
                                    <select>
                                        <option>or select a category</option>
                                        <option>Apetizers</option>
                                        <option>Cocktails</option>
                                        <option>Deserts</option>
                                        <option>Main courses</option>
                                        <option>Snacks</option>
                                        <option>Soups</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--//recipefinder-->
                
                    <!--results-->
                    <div class="entries row">
                        <!--item-->
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
                        <!--item-->
                        
                        <!--item-->
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
                        <!--item-->
                        
                        <!--item-->
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
                        <!--item-->
                        
                        <!--item-->
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
                        <!--item-->
                        
                        <!--item-->
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
                        <!--item-->
                        
                        <!--item-->
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
                        <!--item-->
                        
                        <!--item-->
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
                        <!--item-->
                        
                        <!--item-->
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
                        <!--item-->
                        
                        <!--item-->
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
                        <!--item-->
                        
                        <!--item-->
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
                        <!--item-->
                        
                        <!--item-->
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
                        <!--item-->
                        
                        <!--item-->
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
                        <!--item-->
                        
                        <div class="quicklinks">
                            <a href="#" class="button">More recipes</a>
                            <a href="javascript:void(0)" class="button scroll-to-top">Back to top</a>
                        </div>
                    </div>
                    <!--//results-->
                </section>
                <!--//content-->
            </div>
            <!--//row-->
        </div>
        <!--//wrap-->
    </main>
@endsection
