import type { Product } from "../mocks/products";
import RatingStars from "./RatingStars";

interface Props {
  product: Product
}

const ProductCard: React.FC<Props> = ({ product }) => {
  const formattedPrice = `$${product.price.toFixed(2)}`

  return (
    <article
      className="
        overflow-hidden rounded-xs border border-slate-200 bg-white 
        shadow-sm transition-transform transition-shadow hover:shadow-lg cursor-pointer
      "
    >
      <div className="relative aspect-[1] overflow-hidden">
        <img
          src={product.imageUrl}
          alt={product.name}
          className="h-full w-full object-cover transition-transform duration-300"
        />
        {product.badge && (
          <span className="absolute left-2 top-2 bg-slate-900 rounded-md bg-sky-600 px-2.5 py-1 text-xs font-medium text-white shadow-sm">
            {product.badge}
          </span>
        )}
      </div>
      <div className="space-y-1 px-3.5 py-3">
        <p className="text-[0.7rem] uppercase tracking-wide text-slate-400">
          {product.category}
        </p>
        <p className="line-clamp-2 text-sm font-semibold text-slate-900">
          {product.name}
        </p>
        <p className="text-base font-semibold text-slate-900">
          <RatingStars rating={product.stars}/>
        </p>
        <p className="text-base font-semibold text-slate-900">
          {formattedPrice}
        </p>
        <button
          type="button"
          className="rounded-full bg-sky-600 px-3 py-1.5 text-xs font-semibold text-white shadow-sm transition hover:bg-slate-800 cursor-pointer"
        >
          Add to cart
        </button>
      </div>
    </article>
  )
}

export default ProductCard