import ProductGrid from "../components/ProductGrid";

const Homepage: React.FC = () => {
  return (
    <div className="space-y-6">
      <section className="bg-white border-b-1 border-slate-200/70 px-4 py-4 flex flex-row justify-between">
        <div>
          <h1 className="text-lg sm:text-xl font-semibold">
            Shop essentials, delivered fast.
          </h1>
          <p className="text-sm text-slate-500">
            Browse curated products and track their order lifecycle end-to-end with Orderflow.
          </p>
        </div>
        <div className="flex items-center gap-2 text-sm">
          <span className="inline-flex items-center rounded-full bg-emerald-50 text-emerald-700 px-3 py-1 border border-emerald-100">
            <span className="h-2 w-2 rounded-full bg-emerald-500 mr-2" />
            Live demo environment
          </span>
        </div>
      </section>

      {/* Products */}
      <ProductGrid />
    </div>
  );
};

export default Homepage