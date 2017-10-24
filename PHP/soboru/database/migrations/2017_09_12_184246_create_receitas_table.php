<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateReceitasTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('receitas', function (Blueprint $table) {
            $table->increments('id');
            $table->string('nome')->unique();
            $table->integer('categoria_id');
            $table->integer('user_id');
            $table->string('porcao');
            $table->decimal('tempo_preparo', 5, 2);
            $table->text('modo_preparo');
            $table->string('img_path')->nullable();
            $table->decimal('pontuacao_media', 5, 2)->default('0.0');
            $table->integer('views')->default('0');
            $table->integer('favs')->default('0');
            $table->string('slug')->default('');
            $table->boolean('aprovado')->default('0');
            $table->timestamps();
            $table->softDeletes();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('receitas');
    }
}
