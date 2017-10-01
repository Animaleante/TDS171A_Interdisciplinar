@extends('layouts.site.master')

@section('content')
    <main class="main" role="main">
        <div class="wrap clearfix">
            <nav class="breadcrumbs">
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/receitas">Receitas</a></li>
                    <li><a href="/categorias/{{ $receita->categoria->slug }}">{{ $receita->categoria->nome_categoria }}</a></li>
                    <li>{{ $receita->nome_receita }}</li>
                </ul>
            </nav>
            
            <div class="row">
                <header class="s-title">
                    <h1>{{ $receita->nome_receita }}</h1>
                </header>
                <section class="content three-fourth">
                        <div class="recipe">
                            <div class="row">
                                <article class="two-third">
                                    <div class="image">
                                        <a href="#">
                                            <img src="/{{ $receita->img_path }}" alt="" />
                                        </a>
                                    </div>
                                    <div class="intro">
                                        {{-- <p><strong>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas</strong></p> <p>Molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio.</p> --}}
                                        <p><strong>Modo de preparo</strong></p>
                                        {!! $receita->modo_preparo !!}
                                    </div>
                                    {{-- <div class="instructions">
                                        <ol>
                                            <li>Heat oven to 160C/140C fan/gas 3 and line a 12-hole muffin tin with cases. Gently melt the butter, chocolate, sugar and 100ml hot water together in a large saucepan, stirring occasionally, then set aside to cool a little while you weigh the other ingredients.</li>
                                            <li>Stir the eggs and vanilla into the chocolate mixture. Put the flour into a large mixing bowl, then stir in the chocolate mixture until smooth. Spoon into cases until just over three-quarters full (you may have a little mixture leftover), then set aside for 5 mins before putting on a low shelf in the oven and baking for 20-22 mins. Leave to cool.</li>
                                            <li>For the icing, melt the chocolate in a heatproof bowl over a pan of barely simmering water. Once melted, turn off the heat, stir in the double cream and sift in the icing sugar. When spreadable, top each cake with some and decorate with your favourite sprinkles and sweets.</li>
                                        </ol>
                                    </div> --}}
                                </article>
                                
                                <article class="one-third">
                                    <dl class="basic">
                                        <dt>Tempo de preparo</dt>
                                        <dd>{{ $receita->tempo_preparo }} horas</dd>
                                        {{-- <dt>Cooking time</dt> --}}
                                        {{-- <dd> mins</dd> --}}
                                        {{-- <dt>Difficulty</dt> --}}
                                        {{-- <dd>easy</dd> --}}
                                        <dt>Serve</dt>
                                        <dd>{{ $receita->porcao }} pessoas</dd>
                                    </dl>
                                    
                                    <dl class="user">
                                        <dt>Categoria</dt>
                                        <dd>{{ $receita->categoria->nome_categoria }}</dd>
                                        <dt>Postada por</dt>
                                        <dd>{{ $receita->user->nome_usuario }}</dd>
                                    </dl>
                                    
                                    <dl class="ingredients">
                                        @foreach ($receita->receitasIngredientes as $receitaIngrediente)
                                            <dt>{{$receitaIngrediente->qty}}{{$receitaIngrediente->medida->abreviacao}}</dt>
                                            <dd>{{$receitaIngrediente->ingrediente->nome_ingrediente}}</dd>
                                        @endforeach

                                        {{-- <dt>300g</dt>
                                        <dd>Self-raising flour</dd>
                                        <dt>200g</dt>
                                        <dd>Butter</dd>
                                        <dt>200g</dt>
                                        <dd>Plain chocolate</dd>
                                        <dt>2</dt>
                                        <dd>Eggs</dd>
                                        <dt>1 tbsp</dt>
                                        <dd>Vanilla extract</dd>
                                        <dt>200 g</dt>
                                        <dd>Brown sugar</dd>
                                        <dt>100 ml</dt>
                                        <dd>Double cream</dd>
                                        <dt>handful</dt>
                                        <dd>Sprinkles</dd> --}}
                                    </dl>
                                </article>
                            </div>
                        </div>
                            
                        <div class="comments" id="comments">
                            <h2>{{ count($receita->comentarios) }} comments </h2>
                            <ol class="comment-list">
                                @foreach($receita->comentarios as $comentario)
                                    <li class="comment depth-1">
                                        <div class="avatar">
                                            <a href="my_profile.html">
                                                <img src="https://dummyimage.com/270x270/eee/000000.jpg&text=Avatar" alt="" />
                                            </a>
                                        </div>
                                        <div class="comment-box">
                                            <div class="comment-author meta"> 
                                                <strong>{{ $comentario->user->nome_usuario }}</strong> said {{ $comentario->created_at->diffForHumans() }}</a>
                                            </div>
                                            <div class="comment-text">
                                                <p>{{ $comentario->body }}</p>
                                            </div>
                                        </div> 
                                    </li>
                                @endforeach

                                {{-- <li class="comment depth-1">
                                    <div class="avatar"><a href="my_profile.html"><img src="images/avatar1.jpg" alt="" /></a></div>
                                    <div class="comment-box">
                                        <div class="comment-author meta"> 
                                            <strong>Kimberly C.</strong> said 1 month ago <a href="#" class="comment-reply-link"> Reply</a>
                                        </div>
                                        <div class="comment-text">
                                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation.</p>
                                        </div>
                                    </div> 
                                </li>
                                
                                <li class="comment depth-1">
                                    <div class="avatar"><a href="my_profile.html"><img src="images/avatar2.jpg" alt="" /></a></div>
                                    <div class="comment-box">
                                        <div class="comment-author meta"> 
                                            <strong>Alex J.</strong> said 1 month ago <a href="#" class="comment-reply-link"> Reply</a>
                                        </div>
                                        <div class="comment-text">
                                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation.</p>
                                        </div>
                                    </div> 
                                </li>
                                
                                <li class="comment depth-2">
                                    <div class="avatar"><a href="my_profile.html"><img src="images/avatar1.jpg" alt="" /></a></div>
                                    <div class="comment-box">
                                        <div class="comment-author meta"> 
                                            <strong>Kimberly C.</strong> said 1 month ago <a href="#" class="comment-reply-link"> Reply</a>
                                        </div>
                                        <div class="comment-text">
                                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation.</p>
                                        </div>
                                    </div> 
                                </li>
                                
                                <li class="comment depth-3">
                                    <div class="avatar"><a href="my_profile.html"><img src="images/avatar2.jpg" alt="" /></a></div>
                                    <div class="comment-box">
                                        <div class="comment-author meta"> 
                                            <strong>Alex J.</strong> said 1 month ago <a href="#" class="comment-reply-link"> Reply</a>
                                        </div>
                                        <div class="comment-text">
                                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation.</p>
                                        </div>
                                    </div> 
                                </li>
                                
                                <li class="comment depth-1">
                                    <div class="avatar"><a href="my_profile.html"><img src="images/avatar3.jpg" alt="" /></a></div>
                                    <div class="comment-box">
                                        <div class="comment-author meta"> 
                                            <strong>Denise M.</strong> said 1 month ago <a href="#" class="comment-reply-link"> Reply</a>
                                        </div>
                                        <div class="comment-text">
                                            <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation.</p>
                                        </div>
                                    </div> 
                                </li> --}}
                            </ol>
                        </div>
                        
                        <div class="comment-respond" id="respond">
                            <h2>Deixe um comentario</h2>
                            <div class="container">
                                {{-- <p><strong>Note:</strong> Comments on the web site reflect the views of their authors, and not necessarily the views of the socialchef internet portal. Requested to refrain from insults, swearing and vulgar expression. We reserve the right to delete any comment without notice explanations.</p> --}}
                                {{-- <p>Your email address will not be published. Required fields are signed with <span class="req">*</span></p> --}}
                                <form method="post" action="/receitas/{{ $receita->id }}/comments">
                                    {{ csrf_field() }}

                                    {{-- <div class="f-row">
                                        <div class="third">
                                            <input type="text" placeholder="Your name" />
                                            <span class="req">*</span>
                                        </div>
                                        
                                        <div class="third">
                                            <input type="email" placeholder="Your email" />
                                            <span class="req">*</span>
                                        </div>
                                        
                                        <div class="third">
                                            <input type="text" placeholder="Your website" />
                                        </div>
                                    
                                    </div> --}}

                                    <div class="f-row">
                                        <textarea name="body"></textarea>
                                    </div>
                                    
                                    <div class="f-row">
                                        <div class="third bwrap">
                                            <input type="submit" value="Enviar" />
                                        </div>
                                    </div>
                                    
                                    {{-- <div class="bottom">
                                        <div class="f-row checkbox">
                                            <input type="checkbox" id="ch1" />
                                            <label for="ch1">Notify me of replies to my comment via e-mail</label>
                                        </div>
                                        <div class="f-row checkbox">
                                            <input type="checkbox" id="ch2" />
                                            <label for="ch2">Notify me of new articles by email.</label>
                                        </div>
                                    </div> --}}
                                </form>
                            </div>
                        </div>
                </section>
                
                <aside class="sidebar one-fourth">
                    {{-- <div class="widget nutrition">
                        <h3>Nutrition facts <span>(per serving)</span></h3>
                        <table>
                            <tr>
                                <td>Calories </td>
                                <td>505</td>
                            </tr>
                            <tr>
                                <td>Protein</td>
                                <td>59g</td>
                            </tr>
                            <tr>
                                <td>Carbs</td>
                                <td>59g</td>
                            </tr>
                            <tr>
                                <td>Fat</td>
                                <td>29g</td>
                            </tr>
                            <tr>
                                <td>Saturates</td>
                                <td>17g</td>
                            </tr>
                            <tr>
                                <td>Fibre</td>
                                <td>2g</td>
                            </tr>
                            <tr>
                                <td>Sugar</td>
                                <td>44g</td>
                            </tr>
                            <tr>
                                <td>Salt</td>
                                <td>0.51g</td>
                            </tr>
                        </table>
                    </div> --}}
                    
                    <div class="widget share">
                        <ul class="boxed">
                            <li class="light">
                                <a href="#" title="Facebook">
                                    <i class="fa fa-facebook"></i> <span>Share on Facebook</span>
                                </a>
                            </li>
                            <li class="medium">
                                <a href="#" title="Twitter">
                                    <i class="fa fa-twitter"></i> <span>Share on Twitter</span>
                                </a>
                            </li>
                            <li class="dark">
                                <a href="#" title="Favourites">
                                    <i class="fa fa-heart"></i> <span>Favorita</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                    
                    <div class="widget members">
                        <h3>Members who liked this recipe</h3>
                        <ul class="boxed">
                            <li><div class="avatar"><a href="my_profile.html"><img src="https://dummyimage.com/270x270/eee/000000.jpg&text=Avatar" alt="" /><span>Kimberly C.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="https://dummyimage.com/270x270/eee/000000.jpg&text=Avatar" alt="" /><span>Alex J.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="https://dummyimage.com/270x270/eee/000000.jpg&text=Avatar" alt="" /><span>Denise M.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="https://dummyimage.com/270x270/eee/000000.jpg&text=Avatar" alt="" /><span>Jason H.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="https://dummyimage.com/270x270/eee/000000.jpg&text=Avatar" alt="" /><span>Jennifer W.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="https://dummyimage.com/270x270/eee/000000.jpg&text=Avatar" alt="" /><span>Anabelle Q.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="https://dummyimage.com/270x270/eee/000000.jpg&text=Avatar" alt="" /><span>Thomas M.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="https://dummyimage.com/270x270/eee/000000.jpg&text=Avatar" alt="" /><span>Michelle S.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="https://dummyimage.com/270x270/eee/000000.jpg&text=Avatar" alt="" /><span>Bryan A.</span></a></div></li>
                        </ul>
                    </div>
                </aside>
            </div>
        </div>
    </main>    
@endsection