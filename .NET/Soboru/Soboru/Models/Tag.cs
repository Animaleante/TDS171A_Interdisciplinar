﻿using System;
using System.ComponentModel.DataAnnotations;

namespace Soboru.Models
{
    public class Tag
    {
        [Key]
        public int Id { get; set; }
        public string Nome { get; set; }
        public DateTime CreatedAt { get; set; }
        public DateTime UpdatedAt { get; set; }
        public DateTime? DeletedAt { get; set; }
    }
}