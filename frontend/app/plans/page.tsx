"use client";

import { Navbar } from "@/components/layout/Navbar";
import { Footer } from "@/components/layout/Footer";
import { Button } from "@/components/ui/button";
import { Check, X } from "lucide-react";
import { motion } from "framer-motion";
import Link from "next/link";

const plans = [
    {
        name: "Monthly",
        price: "₹1,500",
        period: "/month",
        features: [
            "Access to Gym Floor",
            "Locker Access",
            "1 Free PT Session",
            "Basic Diet Consultation",
        ],
        notIncluded: ["Group Classes", "Advanced Diet Plan", "Spa Access"],
        popular: false,
        color: "bg-slate-100 dark:bg-slate-800",
    },
    {
        name: "Quarterly",
        price: "₹4,000",
        period: "/3 months",
        features: [
            "Access to Gym Floor",
            "Locker Access",
            "3 Free PT Sessions",
            "Advanced Diet Plan",
            "Group Classes (Limited)",
        ],
        notIncluded: ["Spa Access"],
        popular: true,
        color: "bg-primary/5 border-primary/50 relative overflow-hidden",
    },
    {
        name: "Annual",
        price: "₹12,000",
        period: "/year",
        features: [
            "All Access Gym Floor",
            "Permanent Locker",
            "10 Free PT Sessions",
            "Pro Diet & Workout Plan",
            "Unlimited Group Classes",
            "Spa Access",
        ],
        notIncluded: [],
        popular: false,
        color: "bg-slate-100 dark:bg-slate-800",
    },
];

export default function PlansPage() {
    return (
        <main className="min-h-screen bg-background">
            <Navbar />

            <section className="pt-32 pb-20 px-4">
                <div className="container mx-auto text-center mb-16">
                    <h1 className="text-4xl md:text-6xl font-bold mb-6">
                        Choose Your <span className="text-primary">Journey</span>
                    </h1>
                    <p className="text-xl text-muted-foreground max-w-2xl mx-auto">
                        Transparent pricing. No hidden fees. Just results.
                        <br />
                        <span className="text-sm opacity-70">* Membership requests are subject to Admin approval.</span>
                    </p>
                </div>

                <div className="container mx-auto grid grid-cols-1 md:grid-cols-3 gap-8 max-w-6xl">
                    {plans.map((plan, index) => (
                        <motion.div
                            key={plan.name}
                            initial={{ opacity: 0, y: 20 }}
                            animate={{ opacity: 1, y: 0 }}
                            transition={{ delay: index * 0.1 }}
                            className={`rounded-2xl p-8 border hover:shadow-xl transition-all duration-300 flex flex-col ${plan.color} ${plan.popular ? 'border-primary ring-1 ring-primary shadow-lg shadow-primary/10' : 'border-border'}`}
                        >
                            {plan.popular && (
                                <div className="absolute top-0 right-0 bg-primary text-white text-xs font-bold px-3 py-1 rounded-bl-lg">
                                    MOST POPULAR
                                </div>
                            )}

                            <h3 className="text-2xl font-bold mb-2">{plan.name}</h3>
                            <div className="flex items-baseline gap-1 mb-6">
                                <span className="text-4xl font-extrabold">{plan.price}</span>
                                <span className="text-muted-foreground">{plan.period}</span>
                            </div>

                            <ul className="space-y-4 mb-8 flex-1">
                                {plan.features.map((feature) => (
                                    <li key={feature} className="flex items-center gap-3">
                                        <div className="p-1 rounded-full bg-secondary/10 text-secondary">
                                            <Check className="w-4 h-4" />
                                        </div>
                                        <span className="text-sm">{feature}</span>
                                    </li>
                                ))}
                                {plan.notIncluded.map((feature) => (
                                    <li key={feature} className="flex items-center gap-3 text-muted-foreground/50">
                                        <div className="p-1 rounded-full bg-slate-200 dark:bg-slate-800">
                                            <X className="w-4 h-4" />
                                        </div>
                                        <span className="text-sm line-through">{feature}</span>
                                    </li>
                                ))}
                            </ul>

                            <Button size="lg" className={`w-full ${plan.popular ? 'bg-primary hover:bg-primary/90' : 'bg-slate-900 dark:bg-slate-100 text-white dark:text-slate-900 hover:opacity-90'}`}>
                                Request Enrollment
                            </Button>
                        </motion.div>
                    ))}
                </div>
            </section>

            <Footer />
        </main>
    );
}
