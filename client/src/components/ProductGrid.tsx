import { PRODUCTS } from "../mocks/products"
import ProductCard from "./ProductCard"

const ProductGrid: React.FC = () => {
  return (
    <section>
      <div className="m-auto lg:max-w-[1200px] grid gap-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-5 ">
        {PRODUCTS.map((p) => (
          <ProductCard key={p.id} product={p} />
        ))}
      </div>
    </section>
  )
}

export default ProductGrid