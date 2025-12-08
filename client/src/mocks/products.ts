export interface Product {
  id: string;
  name: string;
  price: number;
  imageUrl: string;
  category: string;
  stars: number;
  badge?: string;
}

export const PRODUCTS: Product[] = [
  {
    id: "1",
    name: "Noise-Cancelling Headphones",
    price: 179.99,
    imageUrl: "https://images.pexels.com/photos/3394664/pexels-photo-3394664.jpeg?auto=compress&cs=tinysrgb&w=800",
    badge: "Popular",
    category: "Electronics",
    stars: 4.5
  },
  {
    id: "2",
    name: "Ergonomic Office Chair",
    price: 249.0,
    imageUrl: "https://images.pexels.com/photos/313782/pexels-photo-313782.jpeg?auto=compress&cs=tinysrgb&w=800",
    badge: "New",
    category: "Home & Office",
    stars: 3.2
  },
  {
    id: "3",
    name: "Mechanical Keyboard",
    price: 129.5,
    imageUrl: "https://images.pexels.com/photos/2115257/pexels-photo-2115257.jpeg?auto=compress&cs=tinysrgb&w=800",
    category: "Electronics",
    stars: 3
  },
  {
    id: "4",
    name: "Insulated Water Bottle",
    price: 29.99,
    imageUrl: "https://images.pexels.com/photos/3738730/pexels-photo-3738730.jpeg?auto=compress&cs=tinysrgb&w=800",
    category: "Lifestyle",
    stars: 4
  },
  {
    id: "5",
    name: "Noise-Cancelling Headphones",
    price: 179.99,
    imageUrl: "https://images.pexels.com/photos/3394664/pexels-photo-3394664.jpeg?auto=compress&cs=tinysrgb&w=800",
    badge: "Popular",
    category: "Electronics",
    stars: 4.5
  },
  {
    id: "6",
    name: "Ergonomic Office Chair",
    price: 249.0,
    imageUrl: "https://images.pexels.com/photos/313782/pexels-photo-313782.jpeg?auto=compress&cs=tinysrgb&w=800",
    badge: "New",
    category: "Home & Office",
    stars: 3.2
  },
  {
    id: "7",
    name: "Mechanical Keyboard",
    price: 129.5,
    imageUrl: "https://images.pexels.com/photos/2115257/pexels-photo-2115257.jpeg?auto=compress&cs=tinysrgb&w=800",
    category: "Electronics",
    stars: 3
  },
  {
    id: "8",
    name: "Insulated Water Bottle",
    price: 29.99,
    imageUrl: "https://images.pexels.com/photos/3738730/pexels-photo-3738730.jpeg?auto=compress&cs=tinysrgb&w=800",
    category: "Lifestyle",
    stars: 4
  },
];