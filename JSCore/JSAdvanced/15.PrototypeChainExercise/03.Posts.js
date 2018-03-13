function solve() {

    class Post {
        constructor(title, content) {
            this.title = title;
            this.content = content;
        }

        toString() {
            return `Post: ${this.title}` + '\n' + `Content: ${this.content}`;
        }
    }

    class SocialMediaPost extends Post {
        constructor(title, content, likes, dislikes) {
            super(title, content);
            this.likes = likes;
            this.dislikes = dislikes;
            this.comments = [];
        }

        addComment(comment) {
            this.comments.push(comment);
        }

        toString() {
            return super.toString() + '\n' +`Rating: ${this.likes - this.dislikes}` +
                (this.comments.length > 0 ?
                '\nComments:\n' + this.comments.map(c => ' * ' + c).join('\n') : '');
        }
    }

    class BlogPost extends Post {
        constructor(title, content, views) {
            super(title, content);
            this.views = views;
        }

        view() {
            this.views++;
            return this;
        }

        toString() {
            return super.toString() + `\nViews: ${this.views}`;
        }
    }

    return {Post, SocialMediaPost, BlogPost};
}

let res = solve();
let Post = res.Post;
let SocialMediaPost = res.SocialMediaPost;
let BlogPost = res.BlogPost;

let post = new Post("bla", "bla bla");
let smp1 = new SocialMediaPost("one", "one one", 18, 15);
smp1.addComment(1);
smp1.addComment(2);
let smp2 = new SocialMediaPost("two", "two two", 12, 15);
let bp = new BlogPost("blog", "blog blog");
console.log(post.toString());
console.log(smp1.toString());
console.log(bp.toString());